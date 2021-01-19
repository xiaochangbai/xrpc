package xyz.javaboy.service;

import org.springframework.stereotype.Service;
import xyz.javaboy.controller.HelloService;
import xyz.javaboy.register.annotation.RpcService;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@RpcService
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "【default】Hi "+name+" welcome!";
    }
}
