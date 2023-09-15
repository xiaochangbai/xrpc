package com.xchb.xrpc.api;

import cn.hutool.core.util.IdUtil;
import com.xchb.xrpc.entity.User;
import com.xchb.xrpc.register.annotation.RpcReference;
import org.springframework.stereotype.Controller;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/18
 * @description Good Good Study,Day Day Up.
 */
@Controller
public class UserController {


    @RpcReference
    private UserService userService;


    public User login(String name,String passwd){
        return userService.login(name, passwd);
    }

    public String register(String name,String passwd) {
        User user = new User(IdUtil.simpleUUID(),name,passwd);
        if(userService.register(user)){
            return "注册成功";
        }
        return "注册失败";
    }
}
