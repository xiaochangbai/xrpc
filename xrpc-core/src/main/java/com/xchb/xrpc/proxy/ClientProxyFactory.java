package com.xchb.xrpc.proxy;

import com.xchb.xrpc.common.ServerParam;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

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
