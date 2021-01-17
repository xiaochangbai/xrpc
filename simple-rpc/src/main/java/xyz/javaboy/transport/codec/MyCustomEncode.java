package xyz.javaboy.transport.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description 自定义编码器.
 */
public class MyCustomEncode extends MessageToByteEncoder {

    private Class aClass;

    public MyCustomEncode(Class aClass){
        this.aClass = aClass;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, ByteBuf byteBuf) throws Exception {
        byte[] bytes = KryoUtil.writeObjectToByteArray(obj);
        byteBuf.writeBytes(bytes);
    }
}
