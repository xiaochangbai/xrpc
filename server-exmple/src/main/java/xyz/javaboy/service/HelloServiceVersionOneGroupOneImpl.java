package xyz.javaboy.service;

import xyz.javaboy.api.HelloService;
import xyz.javaboy.register.annotation.RpcService;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@RpcService(group = "1",version = "1.0")
public class HelloServiceVersionOneGroupOneImpl implements HelloService {

    @Override
    public String hello(String name) {
        return this.getClass().getCanonicalName();
    }
}
