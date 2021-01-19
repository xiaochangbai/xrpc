package xyz.javaboy.loadbalance;

import java.util.List;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/19
 * @description 负载均衡.
 */
public interface LoadBalance {


    Class<?> load(List<Class<?>> serverClass);


}
