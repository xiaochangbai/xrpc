package com.xchb.xrpc.spring;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.xchb.xrpc.common.AppConst;
import com.xchb.xrpc.register.ServerRegister;
import com.xchb.xrpc.register.annotation.EnableXRpc;
import com.xchb.xrpc.register.annotation.RpcReference;
import com.xchb.xrpc.register.annotation.RpcService;
import com.xchb.xrpc.spring.properties.SpringAutoConfigProperties;
import com.xchb.xrpc.transport.server.ServerBooter;
import com.xchb.xrpc.util.SingleFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Arrays;
import java.util.Map;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/19
 * @description 让自定义注解标识的类也交由spring管理.
 */
@Slf4j
public class CustomBeanRegistrar implements ImportBeanDefinitionRegistrar{



    //自定义注解中包扫描的注解属性名
    private String PACKAGE_SCANNER_PARAM = "basePackage";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                                        BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        //获取自定义注解中包含的扫描路径
        Map<String, Object> rpcScanParams =
                annotationMetadata.getAnnotationAttributes(EnableXRpc.class.getCanonicalName());
        String[] tmp = (String[]) rpcScanParams.get(PACKAGE_SCANNER_PARAM);
        String[] basePackage = new String[tmp.length+1];
        ArrayUtil.copy(tmp, basePackage, tmp.length);
        //加入spring配置文件的包
        basePackage[basePackage.length-1]=CustomBeanRegistrar.class.getPackage().getName();
        log.debug("basePackage = {}",Arrays.asList(basePackage));

        //扫描自定义注解
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.addIncludeFilter(new AnnotationTypeFilter(RpcService.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(RpcReference.class));
        scanner.scan(basePackage);


        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(SpringBeanPostProcess.class).getBeanDefinition();
        registry.registerBeanDefinition("springBeanPostProcess",beanDefinition);

    }




}
