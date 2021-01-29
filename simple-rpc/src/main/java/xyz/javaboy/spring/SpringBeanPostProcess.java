package xyz.javaboy.spring;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import xyz.javaboy.common.ServerParam;
import xyz.javaboy.extension.ExtensionLoader;
import xyz.javaboy.proxy.ClientProxyFactory;
import xyz.javaboy.register.ServerRegister;
import xyz.javaboy.register.annotation.RpcReference;
import xyz.javaboy.register.annotation.RpcService;
import xyz.javaboy.register.impl.LocalServerRegister;
import xyz.javaboy.util.SingleFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/18
 * @description Good Good Study,Day Day Up.
 */
@Component
@Slf4j
public class SpringBeanPostProcess implements BeanPostProcessor {


    private ServerRegister serverRegister;

    private ClientProxyFactory proxyFactory = SingleFactory.getInstance(ClientProxyFactory.class);


    public SpringBeanPostProcess(){
        super();
        Class<ServerRegister> local = ExtensionLoader.get(ServerRegister.class, "zk");
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
                ClientProxyFactory proxyFactory = new ClientProxyFactory();
                Object proxyObj = proxyFactory.newProxyInstance(
                        ServerParam.buildRequet(declaringClass, rpcReference.group(), rpcReference.version())
                );
                field.setAccessible(true);
                field.set(bean, proxyObj);
            }

        }

        return bean;
    }
}
