package com.xchb.xrpc.register.annotation;

import java.lang.annotation.*;

/**
 * @author XDD
 * @project xrpc
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
