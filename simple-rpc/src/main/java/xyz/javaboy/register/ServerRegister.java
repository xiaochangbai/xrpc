package xyz.javaboy.register;

import java.net.UnknownHostException;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
public interface ServerRegister {


    void register(String serverName, Class<?> aClass) ;

    void register(Class<?> aClassInterface, Class<?> aClass);

    Class<?> findServer(String serverName);
}
