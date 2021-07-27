package com.xchb.xrpc.config;

import lombok.Data;
import lombok.NonNull;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/7/26
 * @description Good Good Study,Day Day Up.
 */
@Data
public class XrpcConfigProperties {


    /**
     * 是否是服务提供方
     */
    private boolean isServer = false;

    /**
     * 服务提供者对外暴露的端口
     */
    private Integer exportPort = 8770;

    /**
     * 注册中心地址
     */
    private String zkAddr = "localhost:2181";


}
