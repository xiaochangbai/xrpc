package com.xchb.xrpc.spring;

import com.xchb.xrpc.common.ServerParam;
import com.xchb.xrpc.exceptions.BaseException;
import com.xchb.xrpc.extension.ExtensionLoader;
import com.xchb.xrpc.proxy.ClientProxyFactory;
import com.xchb.xrpc.register.ServerRegister;
import com.xchb.xrpc.register.annotation.RpcReference;
import com.xchb.xrpc.register.annotation.RpcService;
import com.xchb.xrpc.util.SingleFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/18
 * @description Good Good Study,Day Day Up.
 */
@Component
@Slf4j
public class SpringBeanPostProcess implements BeanPostProcessor {


    private ServerRegister serverRegister;



    public SpringBeanPostProcess(){
        super();
        Class<ServerRegister> local = ExtensionLoader.get(ServerRegister.class, "zk");
        if(local==null){
            throw new BaseException(500,"注册服务不可用");
        }
        serverRegister = SingleFactory.getInstance(local);
    }


    /**
     * bean初始化
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //注册服务
        RpcService rpcService = bean.getClass().getAnnotation(RpcService.class);
        if(rpcService!=null){
            Class<?> interfaceClass = bean.getClass().getInterfaces()[0];
            ServerParam serverParam = ServerParam
                    .buildServer(interfaceClass,bean.getClass(),rpcService.version(),rpcService.group());
            if(serverRegister.register(serverParam)){
                log.debug("服务注册成功[{}]",serverParam.serverName());
            }else{
                log.error("服务注册失败[{}]",serverParam.serverName());
            }
        }
        return bean;
    }

    /**
     * bean的初始化完成
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.debug(beanName+" = "+bean);
        //依赖注入
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field:declaredFields){

            Class<?> declaringClass = field.getType();
            if(!declaringClass.isInterface()){
                continue;
            }
            RpcReference rpcReference = field.getAnnotation(RpcReference.class);
            if(rpcReference!=null){
                ServerParam serverParam = ServerParam
                        .buildRequet(declaringClass, rpcReference.group(), rpcReference.version());
                Object proxyObj = ClientProxyFactory.newProxyInstance(serverParam);
                field.setAccessible(true);
                field.set(bean, proxyObj);
            }

        }

        return bean;
    }
}
