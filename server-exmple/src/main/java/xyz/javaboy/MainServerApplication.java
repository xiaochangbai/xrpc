package xyz.javaboy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.javaboy.register.annotation.RpcScan;
import xyz.javaboy.service.HelloServiceImpl;
import xyz.javaboy.service.test.TestServcie;
import xyz.javaboy.transport.server.ServerBooter;
import xyz.javaboy.util.AppConst;


/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
@RpcScan(basePackage = {"xyz.javaboy.service"})
public class MainServerApplication {

    public static void main(String[] args) throws InterruptedException {
        //启动netty服务
        new ServerBooter().start(AppConst.SERVER_PORT);

        //加载spring容器
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainServerApplication.class);
    }

}
