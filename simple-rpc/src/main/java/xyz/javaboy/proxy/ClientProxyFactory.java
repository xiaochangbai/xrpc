package xyz.javaboy.proxy;

import cn.hutool.core.util.IdUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.data.Id;
import xyz.javaboy.common.RpcRequest;
import xyz.javaboy.common.RpcResponse;
import xyz.javaboy.common.ServerParam;
import xyz.javaboy.transport.client.ClientBooter;
import xyz.javaboy.util.AppConst;
import xyz.javaboy.util.SingleFactory;
import xyz.javaboy.util.UnProcessRequest;

import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description 动态代理工程.
 */

@Slf4j
public class ClientProxyFactory implements InvocationHandler {

    private ServerParam serverParam;


    public ClientProxyFactory(){
    }
    
    public <T> T newProxyInstance(Class<T> tClass){
        this.serverParam = ServerParam.builder().name(tClass.getCanonicalName()).build();
        Object obj = Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass}, this);
        return tClass.cast(obj);
    } 

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        CompletableFuture<RpcResponse<Object>> completableFuture = new CompletableFuture<>();

        RpcRequest request = RpcRequest.builder().group(serverParam.getGroup())
                .version(serverParam.getVersion())
                .methodName(method.getName())
                .params(args)
                .id(IdUtil.simpleUUID())
                .paramTypes(method.getParameterTypes())
                .serverName(serverParam.getName()).build();

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
