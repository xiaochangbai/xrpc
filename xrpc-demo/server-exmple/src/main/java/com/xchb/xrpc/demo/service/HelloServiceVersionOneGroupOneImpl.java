package com.xchb.xrpc.demo.service;

import com.xchb.xrpc.api.HelloService;
import com.xchb.xrpc.register.annotation.RpcService;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@RpcService(group = "1",version = "1.0")
public class HelloServiceVersionOneGroupOneImpl implements HelloService {

    @Override
    public String hello(String name) {
        return this.getClass().getCanonicalName()+":"+name;
    }
}
