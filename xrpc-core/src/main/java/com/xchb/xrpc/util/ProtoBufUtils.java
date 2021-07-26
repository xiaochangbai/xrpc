package com.xchb.xrpc.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/7/26
 * @description Good Good Study,Day Day Up.
 */
public class ProtoBufUtils {

    public static Object[][] parseObj(Map<String, String> paramInfosMap) {

        Class<?>[] parameterTypes = new Class[paramInfosMap.size()];
        Object[] params = new Object[paramInfosMap.size()];
        int index = 0;

        Iterator<String> iterator = paramInfosMap.keySet().iterator();
        while (iterator.hasNext()){
            try {
                String param = iterator.next();
                String type = paramInfosMap.get(param);
                int tmp = index++;
                parameterTypes[tmp]=Class.forName(type);
                params[tmp] = buildDataByType(type,param);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Object[][] result = new Object[2][parameterTypes.length];
        result[0]=parameterTypes;
        result[1]=params;

        return result;

    }

    private static boolean isPrimitive(Class<?> aClass){
        try {
            return  ((Class<?>)aClass.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPrimitive(Integer.class));
        System.out.println(isPrimitive(Double.class));
        System.out.println(isPrimitive(Character.class));
        System.out.println(isPrimitive(int.class));
        System.out.println(isPrimitive(String.class));
    }

    public static LinkedHashMap<String, String> buildString(Class<?>[] parameterTypes, Object[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if(parameterTypes==null || parameterTypes.length<1 || args==null || args.length<1){
            return linkedHashMap;
        }
        for (int i=0;i<parameterTypes.length;i++){
            Class<?> type = parameterTypes[i];
            Object param = args[i];
            linkedHashMap.put(buildString(type,param),type.getName());
        }

        return linkedHashMap;
    }


    public static Object buildDataByType(Class<?> aClass, String value) {
        if(aClass.isPrimitive() || aClass==String.class){
            return aClass.cast(value);
        }else{
            return JSONObject.parseObject(value,aClass);
        }
    }

    public static Object buildDataByType(String type, String value) {
        try {
            return buildDataByType(Class.forName(type),value);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String buildString(Class type, Object result) {
        if(type.isPrimitive() || type==String.class){
            return (String) result;
        }else{
            return JSONObject.toJSONString(result);
        }
    }

    public static String buildString(String type, Object result) {
        try {
            return buildString(Class.forName(type),result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
