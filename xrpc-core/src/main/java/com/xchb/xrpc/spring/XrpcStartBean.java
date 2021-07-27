package com.xchb.xrpc.spring;

import com.xchb.xrpc.config.XrpcConfigProperties;
import com.xchb.xrpc.exceptions.BaseException;
import com.xchb.xrpc.extension.ExtensionLoader;
import com.xchb.xrpc.register.ServerRegister;
import com.xchb.xrpc.transport.server.ServerBooter;
import com.xchb.xrpc.util.SingleFactory;
import com.xchb.xrpc.util.ZkUtils;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/7/26
 * @description 服务提供者启动器.
 */
public class XrpcStartBean {


    private ServerRegister serverRegister;
    public XrpcStartBean(){
        super();
        Class<ServerRegister> local = ExtensionLoader.get(ServerRegister.class, "zk");
        if(local==null){
            throw new BaseException(500,"注册服务不可用");
        }
        serverRegister = SingleFactory.getInstance(local);
    }


    public XrpcStartBean(XrpcConfigProperties configProperties) throws InterruptedException {
        this();
        SingleFactory.set(ZkUtils.class,new ZkUtils(configProperties.getZkAddr()));
        if(configProperties.isServer()){
            new ServerBooter().start(configProperties.getExportPort());
            SingleFactory.set(XrpcConfigProperties.class, configProperties);
            serverRegister.register();
        }
    }

}
