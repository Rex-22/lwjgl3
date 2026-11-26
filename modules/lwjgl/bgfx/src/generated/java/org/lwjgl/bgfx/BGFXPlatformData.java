/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.bgfx;

import org.jspecify.annotations.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * <pre>{@code
 * struct bgfx_platform_data_t {
 *     void * context;
 *     void * queue;
 *     bgfx_native_window_handle_type_t type;
 * }}</pre>
 */
@NativeType("struct bgfx_platform_data_t")
public class BGFXPlatformData extends Struct<BGFXPlatformData> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        CONTEXT,
        QUEUE,
        TYPE;

    static {
        Layout layout = __struct(
            __member(POINTER_SIZE),
            __member(POINTER_SIZE),
            __member(4)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        CONTEXT = layout.offsetof(0);
        QUEUE = layout.offsetof(1);
        TYPE = layout.offsetof(2);
    }

    protected BGFXPlatformData(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected BGFXPlatformData create(long address, @Nullable ByteBuffer container) {
        return new BGFXPlatformData(address, container);
    }

    /**
     * Creates a {@code BGFXPlatformData} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public BGFXPlatformData(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code context} field. */
    @NativeType("void *")
    public long context() { return ncontext(address()); }
    /** @return the value of the {@code queue} field. */
    @NativeType("void *")
    public long queue() { return nqueue(address()); }
    /** @return the value of the {@code type} field. */
    @NativeType("bgfx_native_window_handle_type_t")
    public int type() { return ntype(address()); }

    /** Sets the specified value to the {@code context} field. */
    public BGFXPlatformData context(@NativeType("void *") long value) { ncontext(address(), value); return this; }
    /** Sets the specified value to the {@code queue} field. */
    public BGFXPlatformData queue(@NativeType("void *") long value) { nqueue(address(), value); return this; }
    /** Sets the specified value to the {@code type} field. */
    public BGFXPlatformData type(@NativeType("bgfx_native_window_handle_type_t") int value) { ntype(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public BGFXPlatformData set(
        long context,
        long queue,
        int type
    ) {
        context(context);
        queue(queue);
        type(type);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public BGFXPlatformData set(BGFXPlatformData src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code BGFXPlatformData} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static BGFXPlatformData malloc() {
        return new BGFXPlatformData(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code BGFXPlatformData} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static BGFXPlatformData calloc() {
        return new BGFXPlatformData(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code BGFXPlatformData} instance allocated with {@link BufferUtils}. */
    public static BGFXPlatformData create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new BGFXPlatformData(memAddress(container), container);
    }

    /** Returns a new {@code BGFXPlatformData} instance for the specified memory address. */
    public static BGFXPlatformData create(long address) {
        return new BGFXPlatformData(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable BGFXPlatformData createSafe(long address) {
        return address == NULL ? null : new BGFXPlatformData(address, null);
    }

    /**
     * Returns a new {@code BGFXPlatformData} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static BGFXPlatformData malloc(MemoryStack stack) {
        return new BGFXPlatformData(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code BGFXPlatformData} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static BGFXPlatformData calloc(MemoryStack stack) {
        return new BGFXPlatformData(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    // -----------------------------------

    /** Unsafe version of {@link #context}. */
    public static long ncontext(long struct) { return memGetAddress(struct + BGFXPlatformData.CONTEXT); }
    /** Unsafe version of {@link #queue}. */
    public static long nqueue(long struct) { return memGetAddress(struct + BGFXPlatformData.QUEUE); }
    /** Unsafe version of {@link #type}. */
    public static int ntype(long struct) { return memGetInt(struct + BGFXPlatformData.TYPE); }

    /** Unsafe version of {@link #context(long) context}. */
    public static void ncontext(long struct, long value) { memPutAddress(struct + BGFXPlatformData.CONTEXT, value); }
    /** Unsafe version of {@link #queue(long) queue}. */
    public static void nqueue(long struct, long value) { memPutAddress(struct + BGFXPlatformData.QUEUE, value); }
    /** Unsafe version of {@link #type(int) type}. */
    public static void ntype(long struct, int value) { memPutInt(struct + BGFXPlatformData.TYPE, value); }

}