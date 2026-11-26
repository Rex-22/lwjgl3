#!/usr/bin/env bash
# Builds libbgfx as a shared library from a bgfx.cmake release tag, so the runtime matches that release's shaderc.
#
#   build-bgfx.sh <bgfx.cmake tag> <output folder> [extra CMake arguments...]
#
# Writes <output>/<library> (libbgfx.dylib, libbgfx.so or bgfx.dll) and <library>.git with the bgfx commit.
set -euo pipefail

tag="$1"
out="$2"
shift 2
work="${RUNNER_TEMP:-${TMPDIR:-/tmp}}/bgfx-build"

rm -rf "$work"
git clone --quiet --depth 1 --branch "$tag" https://github.com/bkaradzic/bgfx.cmake.git "$work/src"
cmake -S "$work/src" -B "$work/build" -G Ninja \
    -DCMAKE_BUILD_TYPE=Release \
    -DBGFX_LIBRARY_TYPE=SHARED \
    -DBGFX_BUILD_TOOLS=OFF \
    -DBGFX_BUILD_EXAMPLES=OFF \
    -DBGFX_INSTALL=OFF \
    -DBGFX_CUSTOM_TARGETS=OFF \
    "$@"
cmake --build "$work/build" --target bgfx

mkdir -p "$out"
case "$(uname -s)" in
    Darwin)
        library=libbgfx.dylib
        cp "$work/build/cmake/bgfx/$library" "$out/"
        strip -u -r "$out/$library"
        codesign --force --sign - "$out/$library"
        ;;
    Linux)
        library=libbgfx.so
        cp "$work/build/cmake/bgfx/$library" "$out/"
        strip "$out/$library"
        ;;
    *)
        library=bgfx.dll
        cp "$(find "$work/build" -name bgfx.dll | head -1)" "$out/"
        ;;
esac
# The bgfx commit bgfx.cmake pins for this tag.
sed -n 's/.*bgfx GIT_REPOSITORY [^ ]* GIT_TAG \([0-9a-f]*\).*/\1/p' "$work/src/CMakeLists.txt" > "$out/$library.git"
echo "Built $out/$library from bgfx $(cat "$out/$library.git")"
