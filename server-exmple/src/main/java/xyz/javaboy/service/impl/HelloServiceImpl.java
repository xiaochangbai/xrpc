package xyz.javaboy.service.impl;

import xyz.javaboy.service.HelloService;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hi "+name+" welcome!";
    }
}
