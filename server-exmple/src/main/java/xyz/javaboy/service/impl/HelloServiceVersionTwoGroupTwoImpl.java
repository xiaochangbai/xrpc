package xyz.javaboy.service.impl;

import xyz.javaboy.service.HelloService;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
public class HelloServiceVersionTwoGroupTwoImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "【版本二、组二】Hi "+name+" welcome!";
    }
}
