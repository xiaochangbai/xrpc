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

    private String id;

    private String serverName;

    private String methodName;

    private Class<?>[] paramTypes;

    private Object[] params;

    private String version;

    private String group;

}
