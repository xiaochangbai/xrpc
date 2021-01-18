package xyz.javaboy;

import cn.hutool.core.util.IdUtil;
import xyz.javaboy.common.ServerParam;
import xyz.javaboy.entity.User;
import xyz.javaboy.proxy.ClientProxyFactory;
import xyz.javaboy.service.HelloService;
import xyz.javaboy.service.UserService;
import xyz.javaboy.util.SingleFactory;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
public class MainClientApplication {

    public static void main(String[] args) {
        //场景代理工厂
        ClientProxyFactory proxyFactory = SingleFactory.getInstance(ClientProxyFactory.class);

        HelloService helloService1 = (HelloService) proxyFactory.newProxyInstance(ServerParam.buildRequet(HelloService.class));
        System.out.println(helloService1.hello("1241414"));


        HelloService helloService2 = (HelloService) proxyFactory.newProxyInstance(ServerParam.buildRequet(HelloService.class,"1","1.0"));
        System.out.println(helloService2.hello("1241414"));

        UserService userService = (UserService) proxyFactory.newProxyInstance(ServerParam.buildRequet(UserService.class));
        User user = new User(IdUtil.simpleUUID(),"XCHB","123456");
        System.out.println(userService.register(user));
        System.out.println(userService.login(user.getName(), user.getPasswd()));
    }

}
