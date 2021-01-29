package xyz.javaboy.register;

import xyz.javaboy.common.ServerParam;
import xyz.javaboy.extension.SPI;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@SPI
public interface ServerRegister {


    /**
     * 服务注册
     * @param serverParam
     * @return
     */
    boolean register(ServerParam serverParam) ;

    /**
     * 服务发现
     * @param serverName
     * @return
     */
    List<ServerParam> find(String serverName);

}
