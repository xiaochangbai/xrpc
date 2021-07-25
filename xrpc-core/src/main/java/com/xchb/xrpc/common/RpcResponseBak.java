package com.xchb.xrpc.common;

import com.xchb.xrpc.common.proto.RpcResponseProto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RpcResponseBak<T> {

    //响应id
    private String id;

    //响应数据
    private T data;

    public static void main(String[] args) {
    }

}
