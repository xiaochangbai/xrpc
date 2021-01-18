package xyz.javaboy.register;

import xyz.javaboy.common.ServerParam;

import java.net.UnknownHostException;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
public interface ServerRegister {


    void register(ServerParam serverParam) ;

    Class<?> findServer(String serverName);

}
