package com.xchb.xrpc.proxy;

import cn.hutool.core.util.IdUtil;
import com.xchb.xrpc.transport.client.ClientBooter;
import com.xchb.xrpc.util.AppConst;
import com.xchb.xrpc.util.SingleFactory;
import com.xchb.xrpc.util.UnProcessRequest;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import lombok.extern.slf4j.Slf4j;
import com.xchb.xrpc.common.ServerParam;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description 动态代理工程.
 */

@Slf4j
public class ClientProxyFactory {


    private ClientProxyFactory() {}

    public static  <T> T newProxyInstance(ServerParam<T> serverParam) {
        Object obj = Proxy.newProxyInstance(serverParam.getInterfaceClass().getClassLoader()
                , new Class[]{serverParam.getInterfaceClass()}, new ClientProxy(serverParam));
        return (T) serverParam.getInterfaceClass().cast(obj);
    }

}
