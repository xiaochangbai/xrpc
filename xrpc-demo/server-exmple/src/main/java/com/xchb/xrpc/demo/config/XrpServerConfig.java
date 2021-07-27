package com.xchb.xrpc.demo.config;

import com.xchb.xrpc.config.XrpcConfigProperties;
import com.xchb.xrpc.spring.XrpcStartBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/7/26
 * @description Good Good Study,Day Day Up.
 */
@Configuration
public class XrpServerConfig {

    @Bean
    public XrpcStartBean xrpcStartBean() throws InterruptedException {
        XrpcConfigProperties configProperties = new XrpcConfigProperties();
        configProperties.setExportPort(9091);
        configProperties.setZkAddr("localhost:2181");
        configProperties.setServer(true);
        return new XrpcStartBean(configProperties);
    }

}
