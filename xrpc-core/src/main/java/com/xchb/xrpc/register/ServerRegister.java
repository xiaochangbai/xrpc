package com.xchb.xrpc.register;

import com.xchb.xrpc.common.ServerParam;
import com.xchb.xrpc.extension.SPI;

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
     * 添加服务
     * @param serverParam
     */
    void put(ServerParam serverParam);


    /**
     * 服务数量
     * @return
     */
    Integer serverCount();


    /**
     * 服务发现
     * @param serverName
     * @return
     */
    List<ServerParam> find(String serverName);
}
