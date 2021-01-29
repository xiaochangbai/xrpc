package xyz.javaboy.service;

import xyz.javaboy.api.HelloService;
import xyz.javaboy.register.annotation.RpcService;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@RpcService
public class HelloServiceTwoImpl implements HelloService {

    @Override
    public String hello(String name) {
        return this.getClass().getCanonicalName();
    }

}
