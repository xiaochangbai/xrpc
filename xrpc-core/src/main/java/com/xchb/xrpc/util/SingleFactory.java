package com.xchb.xrpc.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description 单例对象生成器.
 */

@Slf4j
public class SingleFactory {

    private final static Map<String, Object> MAPS = new HashMap<>();


    public static <T> void set(Class<T> tClass, T t){
        MAPS.put(tClass.getName(),t);
    }

    public static <T> T getInstance(Class<T> aClass) {
        try {
            String key = aClass.getName();
            Object instance = MAPS.get(key);
            if (instance == null) {
                synchronized (aClass) {
                    if (instance == null) {
                        instance = aClass.getDeclaredConstructor().newInstance();
                        MAPS.put(key, instance);
                        Class<?>[] interfaces = aClass.getInterfaces();
                        for(Class<?> iClass:interfaces){
                            MAPS.put(iClass.getName(),instance);
                        }
                    }
                }
            }
            return aClass.cast(instance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            log.error("反射创建实例失败[无参构造]，",e);
        }
        return null;
    }


}
