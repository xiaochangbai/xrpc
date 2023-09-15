package com.xchb.xrpc.spring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = SpringAutoConfigProperties.PRE)
public class SpringAutoConfigProperties {

    public final static String PRE = "app";

    /**
     * 对外暴露的端口
     */
    private Integer exportPort;

    /**
     * 注册中心地址
     */
    private String zkAddr;


}
