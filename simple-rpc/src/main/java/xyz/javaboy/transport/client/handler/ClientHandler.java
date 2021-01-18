package xyz.javaboy.transport.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import xyz.javaboy.common.RpcResponse;
import xyz.javaboy.util.UnProcessRequest;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof RpcResponse){
            RpcResponse response = RpcResponse.class.cast(msg);
            UnProcessRequest.compale(response);
        }
    }
}
