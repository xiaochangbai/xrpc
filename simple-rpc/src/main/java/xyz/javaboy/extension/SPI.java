package xyz.javaboy.extension;

import java.lang.annotation.*;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/19
 * @description 扩展服务接口.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface SPI {
}
