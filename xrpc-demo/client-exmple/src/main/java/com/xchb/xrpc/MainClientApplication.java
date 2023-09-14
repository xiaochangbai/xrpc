package com.xchb.xrpc;

import org.springframework.boot.SpringApplication;
import com.xchb.xrpc.register.annotation.RpcScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@SpringBootApplication
@RpcScan(basePackage = "com.xchb.xrpc")
public class MainClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainClientApplication.class,args);

    }

}
