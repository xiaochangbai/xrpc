package xyz.javaboy.transport.server.handler;

import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import xyz.javaboy.common.RpcRequest;
import xyz.javaboy.common.RpcResponse;
import xyz.javaboy.common.ServerParam;
import xyz.javaboy.exceptions.ServerNotFindExeception;
import xyz.javaboy.extension.ExtensionLoader;
import xyz.javaboy.loadbalance.LoadBalance;
import xyz.javaboy.register.ServerRegister;
import xyz.javaboy.register.impl.LocalServerRegister;
import xyz.javaboy.util.SingleFactory;

import java.lang.reflect.Method;
import java.util.List;

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
