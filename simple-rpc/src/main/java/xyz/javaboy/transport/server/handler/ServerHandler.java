package xyz.javaboy.transport.server.handler;

import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import xyz.javaboy.common.RpcRequest;
import xyz.javaboy.common.RpcResponse;
import xyz.javaboy.register.ServerRegister;
import xyz.javaboy.register.impl.LocalServerRegister;
import xyz.javaboy.util.SingleFactory;

import java.lang.reflect.Method;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof RpcRequest){
            RpcRequest request = RpcRequest.class.cast(msg);
            Object result = assembleResult(request);
            ctx.writeAndFlush(new RpcResponse(request.getId(),result));
        }

    }


    private Object assembleResult(RpcRequest request) {
        try {
            ServerRegister serverRegister = SingleFactory.getInstance(LocalServerRegister.class);
            Class<?> server = serverRegister.findServer(request.getServerName());
            if(server==null){
                log.error("没有发现对应的服务: {}",request.getServerName());
                return null;
            }

            Object obj = SingleFactory.getInstance(server);
            if(obj==null){
                return null;
            }
            Method declaredMethod =
                    obj.getClass().getDeclaredMethod(request.getMethodName(), request.getParamTypes());
            if(declaredMethod==null){
                log.error("没有匹配的方法" );
                return null;
            }
            return declaredMethod.invoke(obj,request.getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
