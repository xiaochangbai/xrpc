package xyz.javaboy.transport.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
public class MyCustomDecode extends ByteToMessageDecoder {


    private Class aClass;


    public MyCustomDecode(Class aClass){
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
