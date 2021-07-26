package com.xchb.xrpc.common;

import com.xchb.xrpc.util.IpUtils;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@Data
@Builder
public class ServerParam<T> implements Serializable {


    private final static Long serialVersionUID = 1L;


    //服务版本
    private String version;

    //服务归属组
    private String group;

    //服务ip
    private String ip;

    //服务接口
    private Class<T> interfaceClass;

    //服务实现
    private Class<?> implClass;

    /**
     * 获取服务名称
     * @return
     */
    public String serverName(){
        return ServerParam.buildServerName(this.interfaceClass.getCanonicalName(), this.version, this.group);
    }




    public static ServerParam buildServer(Class<?> interfaceClass,Class<?> implClass,
                                                 String version,String group){
        return new ServerParam(version, group, IpUtils.localIP(), interfaceClass, implClass);
    }

    public static ServerParam buildRequet(Class<?> interfaceClass,String group,String version){
        return new ServerParam(version, group, null, interfaceClass, null);
    }




    /**
     * 构建服务名称
     * @param InterfaceCanonicalName 服务接口Class名称
     * @param version  服务版本
     * @param group    服务归属组
     * @return
     */
    public static String buildServerName(String InterfaceCanonicalName,String version,String group){
        return InterfaceCanonicalName+":"+version+":"+group;
    }



}
