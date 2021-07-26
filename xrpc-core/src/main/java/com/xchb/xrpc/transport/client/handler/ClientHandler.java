package com.xchb.xrpc.transport.client.handler;

import com.xchb.xrpc.common.proto.RpcResponseProto;
import com.xchb.xrpc.util.UnProcessRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
public class ClientHandler extends SimpleChannelInboundHandler<RpcResponseProto.RpcResponse> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, RpcResponseProto.RpcResponse rpcResponse) throws Exception {
        UnProcessRequest.compale(rpcResponse);
    }


}
