package xyz.javaboy.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description 单例对象生成器.
 */

@Slf4j
public class SingleFactory {

    private final static Map<String, Object> MAPS = new HashMap<>();


    public static <T> T getInstance(Class<T> aClass) {
        try {
            String key = aClass.toString();
            Object instance = MAPS.get(key);
            if (instance == null) {
                synchronized (aClass) {
                    if (instance == null) {
                        instance = aClass.getDeclaredConstructor().newInstance();
                        MAPS.put(key, instance);
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
