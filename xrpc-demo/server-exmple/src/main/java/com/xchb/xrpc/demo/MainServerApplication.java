package com.xchb.xrpc.demo;

import com.xchb.xrpc.util.AppConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.xchb.xrpc.register.annotation.RpcScan;
import com.xchb.xrpc.transport.server.ServerBooter;


/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
@RpcScan(basePackage = {"com.xchb.xrpc.demo.service"})
public class MainServerApplication {

    public static void main(String[] args) throws InterruptedException {
        //启动netty服务
        new ServerBooter().start(AppConst.SERVER_PORT);
        //加载spring容器
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainServerApplication.class);
    }

}
