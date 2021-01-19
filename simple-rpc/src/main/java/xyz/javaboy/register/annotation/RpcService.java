package xyz.javaboy.register.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/11
 * @description Good Good Study,Day Day Up.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RpcService {

    String group() default "";

    String version() default "";

}
