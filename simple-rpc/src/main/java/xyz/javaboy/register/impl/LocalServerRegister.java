package xyz.javaboy.register.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import xyz.javaboy.common.ServerParam;
import xyz.javaboy.register.ServerRegister;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author XDD
 * @project rpc-demo
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
    public void register(ServerParam serverParam) {
        cache.put(serverParam.serverName(), serverParam);
    }

    @Override
    public Class<?> findServer(String serverName) {
        ServerParam serverParam = cache.getIfPresent(serverName);
        if(serverParam==null){
            return null;
        }
        return serverParam.getImplClass();
    }
}
