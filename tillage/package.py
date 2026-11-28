#!/usr/bin/env python3
"""Packages the Tillage LWJGL fork as a file-based Maven repository.

Only two LWJGL modules differ from the upstream release this branch starts from:

* ``org.lwjgl:lwjgl`` (core): the generated ``JNI`` class holds one invoker per native signature that any binding
  uses, so new bgfx signatures need new invokers in core's Java class and in ``liblwjgl``.
* ``org.lwjgl:lwjgl-bgfx``: the binding and ``libbgfx``.

Every other LWJGL module keeps coming from Maven Central at the base version. To keep this fork's jars identical to
upstream apart from what changed (manifests, module-info, multi-release layout, sidecar files), this script starts
from the upstream release jars and replaces only the changed classes and native libraries.

Usage::

    package.py --base 3.4.3 --version 3.4.3.172 --classes bin/classes/lwjgl \\
        --sources modules/lwjgl/bgfx/src/generated/java --natives natives --out maven

``--natives`` holds one folder per Maven classifier (``natives-macos-arm64``, ``natives-windows``, ...), each with
the core and bgfx libraries for that platform, named as LWJGL names them (``liblwjgl.dylib``, ``bgfx.dll``, ...),
plus an optional ``<library>.git`` file with the source commit.
"""

import argparse
import hashlib
import io
import pathlib
import sys
import urllib.request
import zipfile

CENTRAL = "https://repo1.maven.org/maven2/org/lwjgl"

# Maven classifier -> (folder inside the jar, shared library prefix, suffix)
PLATFORMS = {
    "natives-linux": ("linux/x64", "lib", ".so"),
    "natives-linux-arm64": ("linux/arm64", "lib", ".so"),
    "natives-macos": ("macos/x64", "lib", ".dylib"),
    "natives-macos-arm64": ("macos/arm64", "lib", ".dylib"),
    "natives-windows": ("windows/x64", "", ".dll"),
    "natives-windows-arm64": ("windows/arm64", "", ".dll"),
}

# Core classes that the generator rewrites when binding signatures change. On JDK 25 and later, JNI calls through the
# nested JNIBindings interface (FFM downcalls), so it must match JNI.class: upstream's copy lacks the new invokers.
CORE_CLASSES = [
    "org/lwjgl/system/JNI.class",
    "META-INF/versions/25/org/lwjgl/system/JNI.class",
    "META-INF/versions/25/org/lwjgl/system/JNI$JNIBindings.class",
]


def download(url: str) -> bytes:
    with urllib.request.urlopen(url, timeout=120) as response:
        return response.read()


def central(artifact: str, base: str, suffix: str) -> bytes:
    return download(f"{CENTRAL}/{artifact}/{base}/{artifact}-{base}{suffix}")


def rewrite_jar(template: bytes, replace: dict, drop=lambda name: False) -> bytes:
    """Copies ``template``, dropping entries ``drop`` selects and replacing or adding the entries in ``replace``."""
    out = io.BytesIO()
    pending = dict(replace)
    with zipfile.ZipFile(io.BytesIO(template)) as source, zipfile.ZipFile(out, "w", zipfile.ZIP_DEFLATED) as target:
        for info in source.infolist():
            if info.filename in pending:
                target.writestr(info, pending.pop(info.filename))
            elif not drop(info.filename):
                target.writestr(info, source.read(info.filename))
        for name, data in sorted(pending.items()):
            target.writestr(name, data)
    return out.getvalue()


def pom(base_pom: bytes, base: str, version: str) -> bytes:
    # The artifact's own version and its dependency on core both move to the fork version.
    return base_pom.decode("utf-8").replace(f"<version>{base}</version>", f"<version>{version}</version>").encode()


def write(out: pathlib.Path, artifact: str, version: str, suffix: str, data: bytes) -> None:
    folder = out / "org" / "lwjgl" / artifact / version
    folder.mkdir(parents=True, exist_ok=True)
    path = folder / f"{artifact}-{version}{suffix}"
    path.write_bytes(data)
    for algorithm in ("sha1", "sha256"):
        (folder / f"{path.name}.{algorithm}").write_text(hashlib.new(algorithm, data).hexdigest())
    print(f"  {path.relative_to(out)} ({len(data)} bytes)")


def natives_jar(template: bytes, classifier: str, library: str, natives: pathlib.Path) -> bytes:
    folder, prefix, suffix = PLATFORMS[classifier]
    name = f"{prefix}{library}{suffix}"
    binary = (natives / classifier / name).read_bytes()
    revision = natives / classifier / f"{name}.git"
    package = "org/lwjgl" if library == "lwjgl" else f"org/lwjgl/{library}"
    replace = {
        f"{folder}/{package}/{name}": binary,
        f"META-INF/{folder}/{package}/{name}.sha1": hashlib.sha1(binary).hexdigest().encode(),
    }
    if revision.exists():
        replace[f"META-INF/{folder}/{package}/{name}.git"] = revision.read_bytes().strip()
    return rewrite_jar(template, replace)


def main() -> int:
    parser = argparse.ArgumentParser()
    parser.add_argument("--base", required=True, help="Upstream LWJGL release this branch starts from")
    parser.add_argument("--version", required=True, help="Version to publish")
    parser.add_argument("--classes", required=True, type=pathlib.Path, help="LWJGL's bin/classes/lwjgl")
    parser.add_argument("--sources", type=pathlib.Path, help="Generated bgfx Java sources, for a sources jar")
    parser.add_argument("--natives", required=True, type=pathlib.Path)
    parser.add_argument("--out", required=True, type=pathlib.Path)
    parser.add_argument("--platforms", nargs="*", default=sorted(PLATFORMS))
    args = parser.parse_args()

    missing = [c for c in args.platforms if not (args.natives / c).is_dir()]
    if missing:
        print(f"Missing natives for: {', '.join(missing)}", file=sys.stderr)
        return 1

    print(f"Packaging LWJGL {args.version} (from {args.base}) into {args.out}")

    # Core: upstream jar with the regenerated JNI classes.
    core = {name: (args.classes / "core" / name).read_bytes() for name in CORE_CLASSES}
    write(args.out, "lwjgl", args.version, ".jar", rewrite_jar(central("lwjgl", args.base, ".jar"), core))
    write(args.out, "lwjgl", args.version, ".pom", pom(central("lwjgl", args.base, ".pom"), args.base, args.version))

    # bgfx: upstream jar with every class of the binding replaced.
    bgfx_root = args.classes / "bgfx"
    bgfx = {
        path.relative_to(bgfx_root).as_posix(): path.read_bytes()
        for path in sorted(bgfx_root.rglob("*.class"))
        if path.name != "module-info.class"
    }
    if not bgfx:
        print(f"No bgfx classes under {bgfx_root}", file=sys.stderr)
        return 1
    template = central("lwjgl-bgfx", args.base, ".jar")
    jar = rewrite_jar(template, bgfx, drop=lambda name: name.startswith("org/lwjgl/bgfx/"))
    write(args.out, "lwjgl-bgfx", args.version, ".jar", jar)
    write(
        args.out,
        "lwjgl-bgfx",
        args.version,
        ".pom",
        pom(central("lwjgl-bgfx", args.base, ".pom"), args.base, args.version),
    )
    if args.sources:
        sources = io.BytesIO()
        with zipfile.ZipFile(sources, "w", zipfile.ZIP_DEFLATED) as target:
            for path in sorted(args.sources.rglob("*.java")):
                target.write(path, path.relative_to(args.sources).as_posix())
        write(args.out, "lwjgl-bgfx", args.version, "-sources.jar", sources.getvalue())

    for classifier in args.platforms:
        for artifact, library in (("lwjgl", "lwjgl"), ("lwjgl-bgfx", "bgfx")):
            template = central(artifact, args.base, f"-{classifier}.jar")
            jar = natives_jar(template, classifier, library, args.natives)
            write(args.out, artifact, args.version, f"-{classifier}.jar", jar)
    return 0


if __name__ == "__main__":
    sys.exit(main())
