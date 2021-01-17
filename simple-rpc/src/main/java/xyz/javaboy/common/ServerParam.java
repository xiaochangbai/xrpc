package xyz.javaboy.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
@Data
@Builder
public class ServerParam {

    private String version;

    private String group;

    private String name;


    private String ip;

    private Class<?> serverImplClass;

}
