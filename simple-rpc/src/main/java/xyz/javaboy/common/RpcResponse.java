package xyz.javaboy.common;

import lombok.AllArgsConstructor;
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
public class RpcResponse<T> {

    //响应id
    private String id;

    //响应数据
    private T data;

}
