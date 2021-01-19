package xyz.javaboy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import xyz.javaboy.controller.HelloController;
import xyz.javaboy.register.annotation.RpcScan;


/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@RpcScan(basePackage = "xyz.javaboy")
public class MainClientApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainClientApplication.class);
        HelloController helloController = applicationContext.getBean(HelloController.class);
        System.out.println(helloController.hello("xchb"));
        System.out.println(helloController.hello2("xchb"));
    }

}
