package xyz.javaboy.register.annotation;

import java.lang.annotation.*;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyReference {

    String goup() default "";

    String version() default "";

}
