package com.xchb.xrpc;

import com.xchb.xrpc.register.annotation.EnableXRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@SpringBootApplication
@EnableXRpc(basePackage = "com.xchb.xrpc")
public class MainClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainClientApplication.class,args);

    }

}
