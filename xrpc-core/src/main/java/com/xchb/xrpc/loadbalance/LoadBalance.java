package com.xchb.xrpc.loadbalance;

import com.xchb.xrpc.extension.SPI;

import java.util.List;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/19
 * @description 负载均衡.
 */
@SPI
public interface LoadBalance {


    <T> T load(List<T> serverClass);

}
