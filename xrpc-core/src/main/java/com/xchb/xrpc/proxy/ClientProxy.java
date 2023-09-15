package com.xchb.xrpc.proxy;

import cn.hutool.core.util.IdUtil;
import com.xchb.xrpc.common.ServerParam;
import com.xchb.xrpc.common.proto.RpcRequestProto;
import com.xchb.xrpc.common.proto.RpcResponseProto;
import com.xchb.xrpc.exceptions.ServerNotFindExeception;
import com.xchb.xrpc.extension.ExtensionLoader;
import com.xchb.xrpc.loadbalance.LoadBalance;
import com.xchb.xrpc.register.ServerRegister;
import com.xchb.xrpc.transport.client.ClientBooter;
import com.xchb.xrpc.util.ProtoBufUtils;
import com.xchb.xrpc.util.SingleFactory;
import com.xchb.xrpc.util.UnProcessRequest;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/7/25
 * @description 代理客户端.
 */
@Slf4j
public class ClientProxy implements InvocationHandler {

    private Class<ServerRegister> local;
    private ServerRegister serverRegister;
    Class<LoadBalance> algorithm;

    private ServerParam serverParam;


    public ClientProxy(ServerParam serverParam){
        local = ExtensionLoader.get(ServerRegister.class, "zk");
        serverRegister = SingleFactory.getInstance(local);
        algorithm = ExtensionLoader.get(LoadBalance.class, "algorithm");;
        this.serverParam = serverParam;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        CompletableFuture<RpcResponseProto.RpcResponse> completableFuture = new CompletableFuture<>();

        LinkedHashMap<String,String> paramInfo = ProtoBufUtils.buildString(method.getParameterTypes(),args);



        String serverName = ServerParam.buildServerName(serverParam.getInterfaceClassStr(),
                serverParam.getVersion(), serverParam.getGroup());
        List<ServerParam> serverParams = serverRegister.find(serverName);
        log.debug("发现服务列表：{}",serverParams);
        if(serverParams==null || serverParams.size()<1){
            throw new ServerNotFindExeception();
        }

        LoadBalance loadBalance = SingleFactory.getInstance(algorithm);
        ServerParam serverParam = loadBalance.load(serverParams);
        if(serverParam==null){
            log.error("没有发现对应的服务: {}",serverName);
            return null;
        }
        RpcRequestProto.RpcRequest request = RpcRequestProto.RpcRequest
                .newBuilder()
                .setGroup(serverParam.getGroup())
                .setVersion(serverParam.getVersion())
                .setMethodName(method.getName())
                .setId(IdUtil.simpleUUID())
                .setInterfaceClass(serverParam.getImplClassStr())
                .putAllParamInfos(paramInfo)
                .build();

        ClientBooter clientBooter = SingleFactory.getInstance(ClientBooter.class);
        Channel channel = clientBooter.channel(new InetSocketAddress(serverParam.getIp(),serverParam.getPort()));
        channel.writeAndFlush(request).addListener((ChannelFutureListener) future->{
            UnProcessRequest.put(request.getId(),completableFuture);
            if(future.isSuccess()){
                log.debug("信息发送完成");
            }else{
                completableFuture.completeExceptionally(future.cause());
            }
        });
        RpcResponseProto.RpcResponse rpcResponse = completableFuture.get();


        Object data = ProtoBufUtils.buildDataByType(rpcResponse.getDataType(),rpcResponse.getData());
        channel.close();
        return data;
    }
}
