package xyz.javaboy.common;

import lombok.Builder;
import lombok.Data;
import xyz.javaboy.util.IpUtils;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@Data
@Builder
public class ServerParam<T> {

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
        return buildServerName(interfaceClass, this.version, this.getGroup());
    }



    public static ServerParam buildDefaultServer(Class<?> interfaceClass,Class<?> implClass){
        return new ServerParam("", "", IpUtils.localIP(), interfaceClass, implClass);
    }
    public static ServerParam buildServer(Class<?> interfaceClass,Class<?> implClass,
                                                 String version,String group){
        return new ServerParam(version, group, IpUtils.localIP(), interfaceClass, implClass);
    }

    public static ServerParam buildRequet(Class<?> interfaceClass,String group,String version){
        return new ServerParam(version, group, null, interfaceClass, null);
    }

    public static ServerParam buildRequet(Class<?> interfaceClass){
        return new ServerParam("", "", null, interfaceClass, null);
    }


    /**
     * 构建服务名称
     * @param aClass 服务接口Class对象
     * @param version  服务版本
     * @param group    服务归属组
     * @return
     */
    public static String buildServerName(Class<?> aClass,String version,String group){
        return aClass.getCanonicalName()+":"+version+":"+group;
    }

}
