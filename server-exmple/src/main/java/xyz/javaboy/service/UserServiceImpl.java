package xyz.javaboy.service;

import cn.hutool.core.lang.Assert;
import xyz.javaboy.entity.User;
import xyz.javaboy.controller.UserService;
import xyz.javaboy.register.annotation.RpcService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@RpcService
public class UserServiceImpl implements UserService {

    private static final Map<String,User> MAPS = new ConcurrentHashMap<>(5);

    @Override
    public User login(String name, String passwd) {
        Assert.notBlank(name,"用户名不能为空");
        Assert.notBlank(passwd,"密码不能为空");

        User user = MAPS.get(name);
        if(user==null){
            return null;
        }
        if(passwd.equals(user.getPasswd())){
            return user;
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if(user==null || user.isEmpty()){
            return false;
        }
        if(MAPS.get(user.getName())!=null){
            return false;
        }
        MAPS.put(user.getName(), user);
        return true;
    }
}
