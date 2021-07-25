package com.xchb.xrpc.proxy;

import cn.hutool.core.util.IdUtil;
import com.xchb.xrpc.common.RpcRequest;
import com.xchb.xrpc.common.RpcResponse;
import com.xchb.xrpc.common.ServerParam;
import com.xchb.xrpc.transport.client.ClientBooter;
import com.xchb.xrpc.util.AppConst;
import com.xchb.xrpc.util.SingleFactory;
import com.xchb.xrpc.util.UnProcessRequest;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/7/25
 * @description 代理客户端.
 */
@Slf4j
public class ClientProxy implements InvocationHandler {

    private ServerParam serverParam;


    public ClientProxy(ServerParam serverParam){
        this.serverParam = serverParam;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        CompletableFuture<RpcResponse<Object>> completableFuture = new CompletableFuture<>();

        RpcRequest request = RpcRequest.builder().group(serverParam.getGroup())
                .version(serverParam.getVersion())
                .methodName(method.getName())
                .params(args)
                .id(IdUtil.simpleUUID())
                .interfaceClass(serverParam.getInterfaceClass())
                .paramTypes(method.getParameterTypes())
                .build();

        ClientBooter clientBooter = SingleFactory.getInstance(ClientBooter.class);
        Channel channel = clientBooter.channel(new InetSocketAddress(AppConst.SERVER_IP, AppConst.SERVER_PORT));
        channel.writeAndFlush(request).addListener((ChannelFutureListener) future->{
            UnProcessRequest.put(request.getId(),completableFuture);
            if(future.isSuccess()){
                log.debug("信息发送完成");
            }else{
                completableFuture.completeExceptionally(future.cause());
            }
        });
        Object data = completableFuture.get().getData();
        channel.close();
        return data;
    }
}
