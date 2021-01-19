package xyz.javaboy.service;

import xyz.javaboy.controller.HelloService;
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
        return "【版本一、组一】Hi "+name+" welcome!";
    }
}
