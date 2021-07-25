package com.xchb.xrpc.transport.client.handler;

import com.xchb.xrpc.util.UnProcessRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import com.xchb.xrpc.common.RpcResponse;

/**
 * @author XDD
 * @project xrpc
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
