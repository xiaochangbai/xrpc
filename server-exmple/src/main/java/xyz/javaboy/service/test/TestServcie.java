package xyz.javaboy.service.test;

import xyz.javaboy.controller.HelloService;
import xyz.javaboy.register.annotation.RpcService;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/19
 * @description Good Good Study,Day Day Up.
 */

@RpcService
public class TestServcie implements HelloService {

    @Override
    public String hello(String name) {
        return this.getClass().getSimpleName()+"..";
    }
}
