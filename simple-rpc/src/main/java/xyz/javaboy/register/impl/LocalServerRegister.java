package xyz.javaboy.register.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
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
public class LocalServerRegister implements ServerRegister {

    private Cache<String,ServerParam> cache;


    public LocalServerRegister(){
        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(5, TimeUnit.HOURS)
                .build();
    }

    @Override
    public void register(String serverName, Class<?> aClass) {
        ServerParam serverParam = null;
        try {
            serverParam = ServerParam.builder().name(serverName)
                    .group("demo")
                    .version("1.0")
                    .ip(InetAddress.getLocalHost().getHostAddress())
                    .serverImplClass(aClass).build();
            cache.put(serverName, serverParam);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void register(Class<?> aClassInterface, Class<?> aClass) {
        String serverName = aClassInterface.getCanonicalName();
        this.register(serverName, aClass);

    }

    @Override
    public Class<?> findServer(String serverName) {
        ServerParam serverParam = cache.getIfPresent(serverName);
        if(serverParam==null){
            return null;
        }
        return serverParam.getServerImplClass();
    }
}
