package xyz.javaboy.service.impl;

import xyz.javaboy.service.HelloService;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
public class HelloServiceVersionOneGroupOneImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "【版本一、组一】Hi "+name+" welcome!";
    }
}
