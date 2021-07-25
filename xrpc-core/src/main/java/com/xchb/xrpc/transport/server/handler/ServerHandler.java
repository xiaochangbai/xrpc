package com.xchb.xrpc.transport.server.handler;

import com.xchb.xrpc.loadbalance.LoadBalance;
import com.xchb.xrpc.util.SingleFactory;
import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import com.xchb.xrpc.common.RpcRequest;
import com.xchb.xrpc.common.RpcResponse;
import com.xchb.xrpc.common.ServerParam;
import com.xchb.xrpc.exceptions.ServerNotFindExeception;
import com.xchb.xrpc.extension.ExtensionLoader;
import com.xchb.xrpc.register.ServerRegister;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("服务接收到消息,{}",msg);
        if(msg instanceof RpcRequest){
            RpcRequest request = RpcRequest.class.cast(msg);
            Object result = assembleResult(request);
            ctx.writeAndFlush(new RpcResponse(request.getId(),result));
        }

    }


    private Object assembleResult(RpcRequest request) {
        try {
            Class<ServerRegister> local = ExtensionLoader.get(ServerRegister.class, "zk");
            ServerRegister serverRegister = SingleFactory.getInstance(local);
            List<ServerParam> serverParams = serverRegister.find(request.serverName());
            log.debug("发现服务列表：{}",serverParams);
            if(serverParams==null || serverParams.size()<1){
                throw new ServerNotFindExeception();
            }
            Class<LoadBalance> algorithm = ExtensionLoader.get(LoadBalance.class, "algorithm");
            LoadBalance loadBalance = SingleFactory.getInstance(algorithm);
            ServerParam serverParam = loadBalance.load(serverParams);

            if(serverParam==null){
                log.error("没有发现对应的服务: {}",request.serverName());
                return null;
            }

            Object obj = SingleFactory.getInstance(serverParam.getImplClass());
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
