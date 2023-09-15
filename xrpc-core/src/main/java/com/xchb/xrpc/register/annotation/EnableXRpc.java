package com.xchb.xrpc.register.annotation;

import com.xchb.xrpc.spring.CustomBeanRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(CustomBeanRegistrar.class)
public @interface EnableXRpc {

    String[] basePackage();

}
