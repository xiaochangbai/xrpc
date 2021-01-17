package xyz.javaboy.entity;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/17
 * @description Good Good Study,Day Day Up.
 */
@Data
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
