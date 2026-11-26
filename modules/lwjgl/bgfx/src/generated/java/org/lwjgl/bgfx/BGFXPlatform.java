/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.bgfx;

import org.jspecify.annotations.*;

import org.lwjgl.system.*;

import static org.lwjgl.system.APIUtil.*;
import static org.lwjgl.system.JNI.*;

public class BGFXPlatform {

    /** Contains the function pointers loaded from {@code BGFX.getLibrary()}. */
    public static final class Functions {

        private Functions() {}

        /** Function address. */
        public static final long
            render_frame      = apiGetFunctionAddress(BGFX.getLibrary(), "bgfx_render_frame"),
            get_internal_data = apiGetFunctionAddress(BGFX.getLibrary(), "bgfx_get_internal_data");

    }

    public static final int
        BGFX_RENDER_FRAME_NO_CONTEXT = 0,
        BGFX_RENDER_FRAME_RENDER     = 1,
        BGFX_RENDER_FRAME_TIMEOUT    = 2,
        BGFX_RENDER_FRAME_EXITING    = 3,
        BGFX_RENDER_FRAME_COUNT      = 4;

    protected BGFXPlatform() {
        throw new UnsupportedOperationException();
    }

    // --- [ bgfx_render_frame ] ---

    /** {@code bgfx_render_frame_t bgfx_render_frame(int32_t _msecs)} */
    @NativeType("bgfx_render_frame_t")
    public static int bgfx_render_frame(@NativeType("int32_t") int _msecs) {
        long __functionAddress = Functions.render_frame;
        return invokeI(_msecs, __functionAddress);
    }

    // --- [ bgfx_get_internal_data ] ---

    /** {@code bgfx_internal_data_t const * bgfx_get_internal_data(void)} */
    public static long nbgfx_get_internal_data() {
        long __functionAddress = Functions.get_internal_data;
        return invokeP(__functionAddress);
    }

    /** {@code bgfx_internal_data_t const * bgfx_get_internal_data(void)} */
    @NativeType("bgfx_internal_data_t const *")
    public static @Nullable BGFXInternalData bgfx_get_internal_data() {
        long __result = nbgfx_get_internal_data();
        return BGFXInternalData.createSafe(__result);
    }

}