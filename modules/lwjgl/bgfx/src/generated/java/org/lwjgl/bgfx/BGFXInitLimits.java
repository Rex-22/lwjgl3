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
 * struct bgfx_init_limits_t {
 *     uint16_t maxEncoders;
 *     uint32_t numDrawCalls;
 *     uint32_t numDrawCallPeakFrames;
 *     uint32_t minViews;
 *     uint32_t minResourceCbSize;
 *     uint32_t minTransientVbSize;
 *     uint32_t minTransientIbSize;
 *     uint32_t minUniformBufferSize;
 *     uint32_t minUniformCacheSize;
 * }}</pre>
 */
@NativeType("struct bgfx_init_limits_t")
public class BGFXInitLimits extends Struct<BGFXInitLimits> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        MAXENCODERS,
        NUMDRAWCALLS,
        NUMDRAWCALLPEAKFRAMES,
        MINVIEWS,
        MINRESOURCECBSIZE,
        MINTRANSIENTVBSIZE,
        MINTRANSIENTIBSIZE,
        MINUNIFORMBUFFERSIZE,
        MINUNIFORMCACHESIZE;

    static {
        Layout layout = __struct(
            __member(2),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        MAXENCODERS = layout.offsetof(0);
        NUMDRAWCALLS = layout.offsetof(1);
        NUMDRAWCALLPEAKFRAMES = layout.offsetof(2);
        MINVIEWS = layout.offsetof(3);
        MINRESOURCECBSIZE = layout.offsetof(4);
        MINTRANSIENTVBSIZE = layout.offsetof(5);
        MINTRANSIENTIBSIZE = layout.offsetof(6);
        MINUNIFORMBUFFERSIZE = layout.offsetof(7);
        MINUNIFORMCACHESIZE = layout.offsetof(8);
    }

    protected BGFXInitLimits(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected BGFXInitLimits create(long address, @Nullable ByteBuffer container) {
        return new BGFXInitLimits(address, container);
    }

    /**
     * Creates a {@code BGFXInitLimits} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public BGFXInitLimits(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code maxEncoders} field. */
    @NativeType("uint16_t")
    public short maxEncoders() { return nmaxEncoders(address()); }
    /** @return the value of the {@code numDrawCalls} field. */
    @NativeType("uint32_t")
    public int numDrawCalls() { return nnumDrawCalls(address()); }
    /** @return the value of the {@code numDrawCallPeakFrames} field. */
    @NativeType("uint32_t")
    public int numDrawCallPeakFrames() { return nnumDrawCallPeakFrames(address()); }
    /** @return the value of the {@code minViews} field. */
    @NativeType("uint32_t")
    public int minViews() { return nminViews(address()); }
    /** @return the value of the {@code minResourceCbSize} field. */
    @NativeType("uint32_t")
    public int minResourceCbSize() { return nminResourceCbSize(address()); }
    /** @return the value of the {@code minTransientVbSize} field. */
    @NativeType("uint32_t")
    public int minTransientVbSize() { return nminTransientVbSize(address()); }
    /** @return the value of the {@code minTransientIbSize} field. */
    @NativeType("uint32_t")
    public int minTransientIbSize() { return nminTransientIbSize(address()); }
    /** @return the value of the {@code minUniformBufferSize} field. */
    @NativeType("uint32_t")
    public int minUniformBufferSize() { return nminUniformBufferSize(address()); }
    /** @return the value of the {@code minUniformCacheSize} field. */
    @NativeType("uint32_t")
    public int minUniformCacheSize() { return nminUniformCacheSize(address()); }

    /** Sets the specified value to the {@code maxEncoders} field. */
    public BGFXInitLimits maxEncoders(@NativeType("uint16_t") short value) { nmaxEncoders(address(), value); return this; }
    /** Sets the specified value to the {@code numDrawCalls} field. */
    public BGFXInitLimits numDrawCalls(@NativeType("uint32_t") int value) { nnumDrawCalls(address(), value); return this; }
    /** Sets the specified value to the {@code numDrawCallPeakFrames} field. */
    public BGFXInitLimits numDrawCallPeakFrames(@NativeType("uint32_t") int value) { nnumDrawCallPeakFrames(address(), value); return this; }
    /** Sets the specified value to the {@code minViews} field. */
    public BGFXInitLimits minViews(@NativeType("uint32_t") int value) { nminViews(address(), value); return this; }
    /** Sets the specified value to the {@code minResourceCbSize} field. */
    public BGFXInitLimits minResourceCbSize(@NativeType("uint32_t") int value) { nminResourceCbSize(address(), value); return this; }
    /** Sets the specified value to the {@code minTransientVbSize} field. */
    public BGFXInitLimits minTransientVbSize(@NativeType("uint32_t") int value) { nminTransientVbSize(address(), value); return this; }
    /** Sets the specified value to the {@code minTransientIbSize} field. */
    public BGFXInitLimits minTransientIbSize(@NativeType("uint32_t") int value) { nminTransientIbSize(address(), value); return this; }
    /** Sets the specified value to the {@code minUniformBufferSize} field. */
    public BGFXInitLimits minUniformBufferSize(@NativeType("uint32_t") int value) { nminUniformBufferSize(address(), value); return this; }
    /** Sets the specified value to the {@code minUniformCacheSize} field. */
    public BGFXInitLimits minUniformCacheSize(@NativeType("uint32_t") int value) { nminUniformCacheSize(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public BGFXInitLimits set(
        short maxEncoders,
        int numDrawCalls,
        int numDrawCallPeakFrames,
        int minViews,
        int minResourceCbSize,
        int minTransientVbSize,
        int minTransientIbSize,
        int minUniformBufferSize,
        int minUniformCacheSize
    ) {
        maxEncoders(maxEncoders);
        numDrawCalls(numDrawCalls);
        numDrawCallPeakFrames(numDrawCallPeakFrames);
        minViews(minViews);
        minResourceCbSize(minResourceCbSize);
        minTransientVbSize(minTransientVbSize);
        minTransientIbSize(minTransientIbSize);
        minUniformBufferSize(minUniformBufferSize);
        minUniformCacheSize(minUniformCacheSize);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public BGFXInitLimits set(BGFXInitLimits src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code BGFXInitLimits} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static BGFXInitLimits malloc() {
        return new BGFXInitLimits(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code BGFXInitLimits} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static BGFXInitLimits calloc() {
        return new BGFXInitLimits(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code BGFXInitLimits} instance allocated with {@link BufferUtils}. */
    public static BGFXInitLimits create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new BGFXInitLimits(memAddress(container), container);
    }

    /** Returns a new {@code BGFXInitLimits} instance for the specified memory address. */
    public static BGFXInitLimits create(long address) {
        return new BGFXInitLimits(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable BGFXInitLimits createSafe(long address) {
        return address == NULL ? null : new BGFXInitLimits(address, null);
    }

    /**
     * Returns a new {@code BGFXInitLimits} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static BGFXInitLimits malloc(MemoryStack stack) {
        return new BGFXInitLimits(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code BGFXInitLimits} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static BGFXInitLimits calloc(MemoryStack stack) {
        return new BGFXInitLimits(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    // -----------------------------------

    /** Unsafe version of {@link #maxEncoders}. */
    public static short nmaxEncoders(long struct) { return memGetShort(struct + BGFXInitLimits.MAXENCODERS); }
    /** Unsafe version of {@link #numDrawCalls}. */
    public static int nnumDrawCalls(long struct) { return memGetInt(struct + BGFXInitLimits.NUMDRAWCALLS); }
    /** Unsafe version of {@link #numDrawCallPeakFrames}. */
    public static int nnumDrawCallPeakFrames(long struct) { return memGetInt(struct + BGFXInitLimits.NUMDRAWCALLPEAKFRAMES); }
    /** Unsafe version of {@link #minViews}. */
    public static int nminViews(long struct) { return memGetInt(struct + BGFXInitLimits.MINVIEWS); }
    /** Unsafe version of {@link #minResourceCbSize}. */
    public static int nminResourceCbSize(long struct) { return memGetInt(struct + BGFXInitLimits.MINRESOURCECBSIZE); }
    /** Unsafe version of {@link #minTransientVbSize}. */
    public static int nminTransientVbSize(long struct) { return memGetInt(struct + BGFXInitLimits.MINTRANSIENTVBSIZE); }
    /** Unsafe version of {@link #minTransientIbSize}. */
    public static int nminTransientIbSize(long struct) { return memGetInt(struct + BGFXInitLimits.MINTRANSIENTIBSIZE); }
    /** Unsafe version of {@link #minUniformBufferSize}. */
    public static int nminUniformBufferSize(long struct) { return memGetInt(struct + BGFXInitLimits.MINUNIFORMBUFFERSIZE); }
    /** Unsafe version of {@link #minUniformCacheSize}. */
    public static int nminUniformCacheSize(long struct) { return memGetInt(struct + BGFXInitLimits.MINUNIFORMCACHESIZE); }

    /** Unsafe version of {@link #maxEncoders(short) maxEncoders}. */
    public static void nmaxEncoders(long struct, short value) { memPutShort(struct + BGFXInitLimits.MAXENCODERS, value); }
    /** Unsafe version of {@link #numDrawCalls(int) numDrawCalls}. */
    public static void nnumDrawCalls(long struct, int value) { memPutInt(struct + BGFXInitLimits.NUMDRAWCALLS, value); }
    /** Unsafe version of {@link #numDrawCallPeakFrames(int) numDrawCallPeakFrames}. */
    public static void nnumDrawCallPeakFrames(long struct, int value) { memPutInt(struct + BGFXInitLimits.NUMDRAWCALLPEAKFRAMES, value); }
    /** Unsafe version of {@link #minViews(int) minViews}. */
    public static void nminViews(long struct, int value) { memPutInt(struct + BGFXInitLimits.MINVIEWS, value); }
    /** Unsafe version of {@link #minResourceCbSize(int) minResourceCbSize}. */
    public static void nminResourceCbSize(long struct, int value) { memPutInt(struct + BGFXInitLimits.MINRESOURCECBSIZE, value); }
    /** Unsafe version of {@link #minTransientVbSize(int) minTransientVbSize}. */
    public static void nminTransientVbSize(long struct, int value) { memPutInt(struct + BGFXInitLimits.MINTRANSIENTVBSIZE, value); }
    /** Unsafe version of {@link #minTransientIbSize(int) minTransientIbSize}. */
    public static void nminTransientIbSize(long struct, int value) { memPutInt(struct + BGFXInitLimits.MINTRANSIENTIBSIZE, value); }
    /** Unsafe version of {@link #minUniformBufferSize(int) minUniformBufferSize}. */
    public static void nminUniformBufferSize(long struct, int value) { memPutInt(struct + BGFXInitLimits.MINUNIFORMBUFFERSIZE, value); }
    /** Unsafe version of {@link #minUniformCacheSize(int) minUniformCacheSize}. */
    public static void nminUniformCacheSize(long struct, int value) { memPutInt(struct + BGFXInitLimits.MINUNIFORMCACHESIZE, value); }

}