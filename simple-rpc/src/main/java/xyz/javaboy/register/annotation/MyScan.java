package xyz.javaboy.register.annotation;

import lombok.Data;

import java.lang.annotation.*;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface MyScan {

    String basePackage();
}
