package com.xchb.xrpc.register;

import com.xchb.xrpc.extension.SPI;
import com.xchb.xrpc.common.ServerParam;

import java.util.List;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@SPI
public interface ServerRegister {


    /**
     * 服务注册
     * @return
     */
    boolean register() ;



    /**
     * 服务发现
     * @param serverName
     * @return
     */
    List<ServerParam> find(String serverName);

    void put(ServerParam serverParam);
}
