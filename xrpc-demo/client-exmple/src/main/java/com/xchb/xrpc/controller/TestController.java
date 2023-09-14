package com.xchb.xrpc.controller;

import com.xchb.xrpc.api.HelloService;
import com.xchb.xrpc.register.annotation.RpcReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {


    @RpcReference
    private HelloService helloService;

    @RpcReference(group = "1",version = "1.0")
    private HelloService helloService2;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.hello(name);
    }

    @GetMapping("/hello2")
    public String hello2( String name) {
        return helloService2.hello(name);
    }
}
