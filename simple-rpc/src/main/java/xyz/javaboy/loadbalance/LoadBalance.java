package xyz.javaboy.loadbalance;

import xyz.javaboy.extension.SPI;

import java.util.List;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/19
 * @description 负载均衡.
 */
@SPI
public interface LoadBalance {


    <T> T load(List<T> serverClass);

}
