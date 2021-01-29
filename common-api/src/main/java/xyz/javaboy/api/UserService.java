package xyz.javaboy.api;

import xyz.javaboy.entity.User;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
public interface UserService {

    User login(String name,String passwd);

    boolean register(User user);

}
