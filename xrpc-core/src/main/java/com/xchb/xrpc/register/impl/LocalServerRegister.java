package com.xchb.xrpc.register.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.xchb.xrpc.register.ServerRegister;
import lombok.extern.slf4j.Slf4j;
import com.xchb.xrpc.common.ServerParam;


import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
public class LocalServerRegister implements ServerRegister {

    private Cache<String,ServerParam> cache;

    public LocalServerRegister(){
        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(5, TimeUnit.HOURS)
                .build();
    }

    @Override
    public boolean register(ServerParam serverParam) {
        cache.put(serverParam.serverName(), serverParam);
        return true;
    }


    @Override
    public List<ServerParam> find(String serverName) {
        return null;
    }
}
