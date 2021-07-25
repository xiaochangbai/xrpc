package com.xchb.xrpc.api;

import com.xchb.xrpc.entity.User;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
public interface UserService {

    User login(String name,String passwd);

    boolean register(User user);

}
