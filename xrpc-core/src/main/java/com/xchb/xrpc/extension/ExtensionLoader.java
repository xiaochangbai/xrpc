package com.xchb.xrpc.extension;

import com.xchb.xrpc.register.ServerRegister;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/19
 * @description Good Good Study,Day Day Up.
 */
@Slf4j
public class ExtensionLoader {

    //扩展文件根路径
    private final static String EXTENSION_ROOT_PATH = "META-INF/xrpc/";

    //Map<文件名称,Map<文件中key,value>>>
    private final static Map<String,Map<String,Class<?>>> EXTENSION_LOADERS = new ConcurrentHashMap<>();


    public static <T> Class<T> get(Class<T> interfaceClass, String key){
        //校验
        if(!validation(interfaceClass,key)){
            return null;
        }
        //根据接口获取拓展文件中的数据
        String fileName = interfaceClass.getCanonicalName();
        Map<String, Class<?>> classMap = EXTENSION_LOADERS.get(fileName);
        if(EXTENSION_LOADERS.get(fileName)==null){
            //重新加载文件列表
            try {
                classMap = onloadFile(fileName);
            } catch (URISyntaxException e) {
                log.error("加载扩展文件异常，",e);
                return null;
            }
            if(classMap==null){
                return null;
            }
            EXTENSION_LOADERS.put(fileName, classMap);
        }
        //根据key取值

        return (Class<T>) classMap.get(key);
    }

    private static Map<String, Class<?>> onloadFile(String fileName) throws URISyntaxException {
        Map<String,Class<?>> result = new HashMap<>();
        InputStream resourceAsStream = ExtensionLoader.class
                .getClassLoader().getResourceAsStream(EXTENSION_ROOT_PATH + fileName);
        if(resourceAsStream==null){
            return null;
        }
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(resourceAsStream))) {
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                int index = line.indexOf("#");
                if(index==0){
                    //当前行为注释
                    continue;
                }
                if(index!=-1){
                    line = line.substring(0, index);  //过滤掉尾注
                }

                index = line.indexOf("=");
                if(index==-1 || index>line.length()){
                    continue;   //当前行格式不正确
                }
                String key = line.substring(0, index).trim();
                String value = line.substring(index+1, line.length()).trim();
                try {
                    result.put(key, Class.forName(value));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(resourceAsStream!=null)
                    resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static boolean validation(Class<?> interfaceClass, String key) {
        if(interfaceClass==null || key==null){
            log.error("接口和key都不能为空");
            return false;
        }
        SPI spi = interfaceClass.getAnnotation(SPI.class);
        if(spi==null){
            log.error("接口不支持扩展，如有需要请加上@SPI注解");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Class<?> local = ExtensionLoader.get(ServerRegister.class, "local");
        local = ExtensionLoader.get(ServerRegister.class, "local");
        System.out.println(local);
    }

}
