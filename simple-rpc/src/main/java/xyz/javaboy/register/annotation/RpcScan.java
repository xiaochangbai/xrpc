package xyz.javaboy.register.annotation;

import lombok.Data;
import org.springframework.context.annotation.Import;
import xyz.javaboy.spring.CustomBeanRegistrar;

import java.lang.annotation.*;
import java.util.List;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(CustomBeanRegistrar.class)
public @interface RpcScan {

    String[] basePackage();

}
