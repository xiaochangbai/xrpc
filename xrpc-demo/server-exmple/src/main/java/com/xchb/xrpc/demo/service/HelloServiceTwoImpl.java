package com.xchb.xrpc.demo.service;

import com.xchb.xrpc.api.HelloService;
import com.xchb.xrpc.register.annotation.RpcService;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@RpcService
public class HelloServiceTwoImpl implements HelloService {

    @Override
    public String hello(String name) {
        return this.getClass().getCanonicalName()+":"+name;
    }

}
