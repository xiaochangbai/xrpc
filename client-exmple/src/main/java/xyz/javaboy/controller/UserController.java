package xyz.javaboy.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Controller;
import xyz.javaboy.entity.User;
import xyz.javaboy.register.annotation.RpcReference;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/18
 * @description Good Good Study,Day Day Up.
 */
@Controller
public class UserController {


    @RpcReference
    private UserService userService;


    public User hello(String name,String passwd){
        return userService.login(name, passwd);
    }

    public String hello2(String name,String passwd) {
        User user = new User(IdUtil.simpleUUID(),name,passwd);
        if(userService.register(user)){
            return "注册成功";
        }
        return "注册失败";
    }
}
