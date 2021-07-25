package com.xchb.xrpc.util;

import com.xchb.xrpc.common.RpcResponse;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description 未处理的请求处理器.
 */
public class UnProcessRequest {

    private final static Map<String, CompletableFuture> MAPS = new ConcurrentHashMap<>(10);


    public static void put(String requestId,CompletableFuture completableFuture){
        UnProcessRequest.MAPS.put(requestId, completableFuture);
    }

    public static void compale(RpcResponse rpcResponse){
        CompletableFuture completableFuture = MAPS.get(rpcResponse.getId());
        if(completableFuture!=null){
            completableFuture.complete(rpcResponse);
        }
    }
}
