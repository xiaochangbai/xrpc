package xyz.javaboy;

import lombok.extern.slf4j.Slf4j;
import xyz.javaboy.common.ServerParam;
import xyz.javaboy.register.ServerRegister;
import xyz.javaboy.register.impl.LocalServerRegister;
import xyz.javaboy.service.HelloService;
import xyz.javaboy.service.UserService;
import xyz.javaboy.service.impl.HelloServiceImpl;
import xyz.javaboy.service.impl.HelloServiceVersionOneGroupOneImpl;
import xyz.javaboy.service.impl.HelloServiceVersionTwoGroupTwoImpl;
import xyz.javaboy.service.impl.UserServiceImpl;
import xyz.javaboy.transport.server.ServerBooter;
import xyz.javaboy.util.AppConst;
import xyz.javaboy.util.SingleFactory;


/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
public class MainServerApplication {

    public static void main(String[] args) throws InterruptedException {
        //启动服务
        new ServerBooter().start(AppConst.SERVER_PORT);

        //服务注册
        ServerRegister register = SingleFactory.getInstance(LocalServerRegister.class);
        register.register(ServerParam.buildDefaultServer(HelloService.class, HelloServiceImpl.class));
        register.register(ServerParam.buildServer(HelloService.class, HelloServiceVersionOneGroupOneImpl.class,"1.0","1"));
        register.register(ServerParam.buildServer(HelloService.class, HelloServiceVersionTwoGroupTwoImpl.class,"2.0","2"));
        register.register(ServerParam.buildDefaultServer(UserService.class, UserServiceImpl.class));
        log.info("服务注册完成");
    }

}
