package xyz.javaboy.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RpcRequest {

    //请求id
    private String id;

    //服务方法名称
    private String methodName;

    //参数类型
    private Class<?>[] paramTypes;

    //参数
    private Object[] params;

    //版本
    private String version;

    //组
    private String group;

    //服务接口
    private Class<?> interfaceClass;


    public String serverName(){
        return ServerParam.buildServerName(this.interfaceClass, this.version, this.group);
    }
}
