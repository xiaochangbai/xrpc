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

    //服务端口号
    private Integer port;

    //服务接口
    private String interfaceClassStr;

    //服务实现
    private String implClassStr;

    /**
     * 获取服务名称
     * @return
     */
    public String serverName(){
        return ServerParam.buildServerName(this.interfaceClassStr, this.version, this.group);
    }


    public static ServerParam buildServer(Class<?> interfaceClass,Class<?> implClass,
                                                 String version,String group){
        return new ServerParam(version, group, IpUtils.localIP(),0, interfaceClass.getName(), implClass.getName());
    }

    public static ServerParam buildRequet(Class<?> interfaceClass,String group,String version){
        return new ServerParam(version, group, null,null, interfaceClass.getName(), null);
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


    public Class<?> getInterfaceClass() {
        try {
            return Class.forName(this.interfaceClassStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class<?> getImplClass() {
        try {
            return Class.forName(this.implClassStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
