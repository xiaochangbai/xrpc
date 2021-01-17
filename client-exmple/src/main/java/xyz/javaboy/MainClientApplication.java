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


        HelloService helloService = proxyFactory.newProxyInstance(HelloService.class);
        System.out.println(helloService.hello("1241414"));

        UserService userService = proxyFactory.newProxyInstance(UserService.class);
        User user = new User(IdUtil.simpleUUID(),"XCHB","123456");
        System.out.println(userService.register(user));
        System.out.println(userService.login(user.getName(), user.getPasswd()));
    }

}
