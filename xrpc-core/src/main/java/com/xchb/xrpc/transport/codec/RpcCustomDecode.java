package com.xchb.xrpc.transport.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
public class RpcCustomDecode extends ByteToMessageDecoder {


    private Class aClass;


    public RpcCustomDecode(Class aClass){
        this.aClass = aClass;
    }


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        Object obj = KryoUtil.readFromByteArray(bytes,aClass);
        list.add(aClass.cast(obj));
    }
}
