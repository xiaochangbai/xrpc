package com.xchb.xrpc.config;

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
public class XrpClientConfig {

    @Bean
    public XrpcStartBean xrpcStartBean() throws InterruptedException {
        XrpcConfigProperties configProperties = new XrpcConfigProperties();
        configProperties.setZkAddr("localhost:2181");
        return new XrpcStartBean(configProperties);
    }

}
