# LWJGL for Tillage

Branch `tillage/bgfx-172` is LWJGL 3.4.3 with the bgfx binding updated to bgfx API 172 (depth bias, depth control,
swap chains and the rest of the API between 157 and 172). The first commit is upstream's API 157 update,
cherry-picked from LWJGL `master`.

Only two artifacts differ from upstream, both published as `3.4.3.172`:

| Artifact | Why it changes |
|----------|----------------|
| `org.lwjgl:lwjgl` | The generated `JNI` class (and `liblwjgl`) holds one invoker per native signature that any binding uses. New bgfx signatures need new invokers. The 12 invokers dropped are ones only the old bgfx binding used. |
| `org.lwjgl:lwjgl-bgfx` | The binding and `libbgfx`. |

Every other LWJGL module keeps coming from Maven Central at 3.4.3. `tillage/package.py` starts from the upstream
3.4.3 jars and replaces only the changed classes and libraries, so manifests, module-info and the multi-release
layout stay as upstream ships them. The version's extra numeric part (`.172`) makes Gradle pick this core over the
`3.4.3` that other modules' POMs request.

`libbgfx` is built with bgfx.cmake (`tillage/build-bgfx.sh`) from the same release tag as the `shaderc` Tillage
downloads, so shaders and runtime always match.

## Publishing

1. Run the **Tillage LWJGL** workflow on this branch (Actions tab, or `gh workflow run tillage.yml --ref tillage/bgfx-172`).
   It builds natives for Windows, macOS and Linux (x64 and arm64), packages the Maven repository and attaches
   `tillage-lwjgl-<version>.zip` to the release `tillage-<version>`.
2. In Tillage, run `vendor/update-lwjgl.sh <version>` and commit `vendor/maven`.

## Updating bgfx

1. Pick a bgfx.cmake release (`gh release list -R bkaradzic/bgfx.cmake`); the middle number is the API version.
2. Diff `scripts/bgfx.idl` in bgfx between the current and the new pinned commit, and mirror it in
   `modules/lwjgl/bgfx/src/templates/kotlin/bgfx/BGFXTypes.kt` and `templates/BGFX.kt`. Take constant values from
   the new `include/bgfx/defines.h`; removed caps renumber the rest.
3. `ant compile-templates generate`, commit the templates and the generated sources (bgfx and core `JNI`).
4. Set `TILLAGE_VERSION` and `BGFX_CMAKE_TAG` in `.github/workflows/tillage.yml`, run the workflow.
5. In Tillage, bump `lwjgl-fork` in `gradle/libs.versions.toml`, repin `PrepareBgfxTools` and the expected
   `shaderc` version to the same bgfx.cmake release, and port `engine-rhi-bgfx`.
