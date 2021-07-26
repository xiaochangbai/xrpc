package com.xchb.xrpc.entity;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String name;

    private String passwd;


    public boolean isEmpty(){
        if(StrUtil.isEmpty(this.name) && StrUtil.isEmpty(this.passwd)){
            return true;
        }
        return false;
    }



}
