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
 * struct bgfx_swap_chain_t {
 *     void * nwh;
 *     void * ndt;
 *     uint32_t width;
 *     uint32_t height;
 *     uint32_t flags;
 *     bgfx_texture_format_t formatColor;
 *     bgfx_texture_format_t formatDepthStencil;
 *     bgfx_texture_handle_t depth;
 *     uint8_t numBackBuffers;
 *     uint8_t maxFrameLatency;
 * }}</pre>
 */
@NativeType("struct bgfx_swap_chain_t")
public class BGFXSwapChain extends Struct<BGFXSwapChain> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        NWH,
        NDT,
        WIDTH,
        HEIGHT,
        FLAGS,
        FORMATCOLOR,
        FORMATDEPTHSTENCIL,
        DEPTH,
        NUMBACKBUFFERS,
        MAXFRAMELATENCY;

    static {
        Layout layout = __struct(
            __member(POINTER_SIZE),
            __member(POINTER_SIZE),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(2),
            __member(1),
            __member(1)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        NWH = layout.offsetof(0);
        NDT = layout.offsetof(1);
        WIDTH = layout.offsetof(2);
        HEIGHT = layout.offsetof(3);
        FLAGS = layout.offsetof(4);
        FORMATCOLOR = layout.offsetof(5);
        FORMATDEPTHSTENCIL = layout.offsetof(6);
        DEPTH = layout.offsetof(7);
        NUMBACKBUFFERS = layout.offsetof(8);
        MAXFRAMELATENCY = layout.offsetof(9);
    }

    protected BGFXSwapChain(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected BGFXSwapChain create(long address, @Nullable ByteBuffer container) {
        return new BGFXSwapChain(address, container);
    }

    /**
     * Creates a {@code BGFXSwapChain} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public BGFXSwapChain(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code nwh} field. */
    @NativeType("void *")
    public long nwh() { return nnwh(address()); }
    /** @return the value of the {@code ndt} field. */
    @NativeType("void *")
    public long ndt() { return nndt(address()); }
    /** @return the value of the {@code width} field. */
    @NativeType("uint32_t")
    public int width() { return nwidth(address()); }
    /** @return the value of the {@code height} field. */
    @NativeType("uint32_t")
    public int height() { return nheight(address()); }
    /** @return the value of the {@code flags} field. */
    @NativeType("uint32_t")
    public int flags() { return nflags(address()); }
    /** @return the value of the {@code formatColor} field. */
    @NativeType("bgfx_texture_format_t")
    public int formatColor() { return nformatColor(address()); }
    /** @return the value of the {@code formatDepthStencil} field. */
    @NativeType("bgfx_texture_format_t")
    public int formatDepthStencil() { return nformatDepthStencil(address()); }
    /** @return the value of the {@code depth} field. */
    @NativeType("bgfx_texture_handle_t")
    public short depth() { return ndepth(address()); }
    /** @return the value of the {@code numBackBuffers} field. */
    @NativeType("uint8_t")
    public byte numBackBuffers() { return nnumBackBuffers(address()); }
    /** @return the value of the {@code maxFrameLatency} field. */
    @NativeType("uint8_t")
    public byte maxFrameLatency() { return nmaxFrameLatency(address()); }

    /** Sets the specified value to the {@code nwh} field. */
    public BGFXSwapChain nwh(@NativeType("void *") long value) { nnwh(address(), value); return this; }
    /** Sets the specified value to the {@code ndt} field. */
    public BGFXSwapChain ndt(@NativeType("void *") long value) { nndt(address(), value); return this; }
    /** Sets the specified value to the {@code width} field. */
    public BGFXSwapChain width(@NativeType("uint32_t") int value) { nwidth(address(), value); return this; }
    /** Sets the specified value to the {@code height} field. */
    public BGFXSwapChain height(@NativeType("uint32_t") int value) { nheight(address(), value); return this; }
    /** Sets the specified value to the {@code flags} field. */
    public BGFXSwapChain flags(@NativeType("uint32_t") int value) { nflags(address(), value); return this; }
    /** Sets the specified value to the {@code formatColor} field. */
    public BGFXSwapChain formatColor(@NativeType("bgfx_texture_format_t") int value) { nformatColor(address(), value); return this; }
    /** Sets the specified value to the {@code formatDepthStencil} field. */
    public BGFXSwapChain formatDepthStencil(@NativeType("bgfx_texture_format_t") int value) { nformatDepthStencil(address(), value); return this; }
    /** Sets the specified value to the {@code depth} field. */
    public BGFXSwapChain depth(@NativeType("bgfx_texture_handle_t") short value) { ndepth(address(), value); return this; }
    /** Sets the specified value to the {@code numBackBuffers} field. */
    public BGFXSwapChain numBackBuffers(@NativeType("uint8_t") byte value) { nnumBackBuffers(address(), value); return this; }
    /** Sets the specified value to the {@code maxFrameLatency} field. */
    public BGFXSwapChain maxFrameLatency(@NativeType("uint8_t") byte value) { nmaxFrameLatency(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public BGFXSwapChain set(
        long nwh,
        long ndt,
        int width,
        int height,
        int flags,
        int formatColor,
        int formatDepthStencil,
        short depth,
        byte numBackBuffers,
        byte maxFrameLatency
    ) {
        nwh(nwh);
        ndt(ndt);
        width(width);
        height(height);
        flags(flags);
        formatColor(formatColor);
        formatDepthStencil(formatDepthStencil);
        depth(depth);
        numBackBuffers(numBackBuffers);
        maxFrameLatency(maxFrameLatency);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public BGFXSwapChain set(BGFXSwapChain src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code BGFXSwapChain} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static BGFXSwapChain malloc() {
        return new BGFXSwapChain(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code BGFXSwapChain} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static BGFXSwapChain calloc() {
        return new BGFXSwapChain(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code BGFXSwapChain} instance allocated with {@link BufferUtils}. */
    public static BGFXSwapChain create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new BGFXSwapChain(memAddress(container), container);
    }

    /** Returns a new {@code BGFXSwapChain} instance for the specified memory address. */
    public static BGFXSwapChain create(long address) {
        return new BGFXSwapChain(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable BGFXSwapChain createSafe(long address) {
        return address == NULL ? null : new BGFXSwapChain(address, null);
    }

    /**
     * Returns a new {@code BGFXSwapChain} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static BGFXSwapChain malloc(MemoryStack stack) {
        return new BGFXSwapChain(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code BGFXSwapChain} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static BGFXSwapChain calloc(MemoryStack stack) {
        return new BGFXSwapChain(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    // -----------------------------------

    /** Unsafe version of {@link #nwh}. */
    public static long nnwh(long struct) { return memGetAddress(struct + BGFXSwapChain.NWH); }
    /** Unsafe version of {@link #ndt}. */
    public static long nndt(long struct) { return memGetAddress(struct + BGFXSwapChain.NDT); }
    /** Unsafe version of {@link #width}. */
    public static int nwidth(long struct) { return memGetInt(struct + BGFXSwapChain.WIDTH); }
    /** Unsafe version of {@link #height}. */
    public static int nheight(long struct) { return memGetInt(struct + BGFXSwapChain.HEIGHT); }
    /** Unsafe version of {@link #flags}. */
    public static int nflags(long struct) { return memGetInt(struct + BGFXSwapChain.FLAGS); }
    /** Unsafe version of {@link #formatColor}. */
    public static int nformatColor(long struct) { return memGetInt(struct + BGFXSwapChain.FORMATCOLOR); }
    /** Unsafe version of {@link #formatDepthStencil}. */
    public static int nformatDepthStencil(long struct) { return memGetInt(struct + BGFXSwapChain.FORMATDEPTHSTENCIL); }
    /** Unsafe version of {@link #depth}. */
    public static short ndepth(long struct) { return memGetShort(struct + BGFXSwapChain.DEPTH); }
    /** Unsafe version of {@link #numBackBuffers}. */
    public static byte nnumBackBuffers(long struct) { return memGetByte(struct + BGFXSwapChain.NUMBACKBUFFERS); }
    /** Unsafe version of {@link #maxFrameLatency}. */
    public static byte nmaxFrameLatency(long struct) { return memGetByte(struct + BGFXSwapChain.MAXFRAMELATENCY); }

    /** Unsafe version of {@link #nwh(long) nwh}. */
    public static void nnwh(long struct, long value) { memPutAddress(struct + BGFXSwapChain.NWH, value); }
    /** Unsafe version of {@link #ndt(long) ndt}. */
    public static void nndt(long struct, long value) { memPutAddress(struct + BGFXSwapChain.NDT, value); }
    /** Unsafe version of {@link #width(int) width}. */
    public static void nwidth(long struct, int value) { memPutInt(struct + BGFXSwapChain.WIDTH, value); }
    /** Unsafe version of {@link #height(int) height}. */
    public static void nheight(long struct, int value) { memPutInt(struct + BGFXSwapChain.HEIGHT, value); }
    /** Unsafe version of {@link #flags(int) flags}. */
    public static void nflags(long struct, int value) { memPutInt(struct + BGFXSwapChain.FLAGS, value); }
    /** Unsafe version of {@link #formatColor(int) formatColor}. */
    public static void nformatColor(long struct, int value) { memPutInt(struct + BGFXSwapChain.FORMATCOLOR, value); }
    /** Unsafe version of {@link #formatDepthStencil(int) formatDepthStencil}. */
    public static void nformatDepthStencil(long struct, int value) { memPutInt(struct + BGFXSwapChain.FORMATDEPTHSTENCIL, value); }
    /** Unsafe version of {@link #depth(short) depth}. */
    public static void ndepth(long struct, short value) { memPutShort(struct + BGFXSwapChain.DEPTH, value); }
    /** Unsafe version of {@link #numBackBuffers(byte) numBackBuffers}. */
    public static void nnumBackBuffers(long struct, byte value) { memPutByte(struct + BGFXSwapChain.NUMBACKBUFFERS, value); }
    /** Unsafe version of {@link #maxFrameLatency(byte) maxFrameLatency}. */
    public static void nmaxFrameLatency(long struct, byte value) { memPutByte(struct + BGFXSwapChain.MAXFRAMELATENCY, value); }

}