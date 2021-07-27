package com.xchb.xrpc;

import com.xchb.xrpc.api.HelloController;
import com.xchb.xrpc.api.UserController;
import com.xchb.xrpc.api.UserService;
import com.xchb.xrpc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.xchb.xrpc.register.annotation.RpcScan;


/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@RpcScan(basePackage = "com.xchb.xrpc")
public class MainClientApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainClientApplication.class);
        HelloController helloController = applicationContext.getBean(HelloController.class);
        System.out.println(helloController.hello("xchb-----------------------"));
        System.out.println(helloController.hello("xchb-----------------------"));
        System.out.println(helloController.hello("xchb-----------------------"));
        System.out.println(helloController.hello("xchb-----------------------"));
        System.out.println(helloController.hello2("xchb-----------------------"));
        UserController userController = applicationContext.getBean(UserController.class);
        userController.register("xcc","aa");
        User user = userController.login("xcc", "aa");
        System.out.println(user+"xchb-----------------------");
    }

}
