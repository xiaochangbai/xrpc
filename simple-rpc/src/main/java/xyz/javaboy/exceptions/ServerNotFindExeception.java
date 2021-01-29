package xyz.javaboy.exceptions;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/29
 * @description Good Good Study,Day Day Up.
 */
public class ServerNotFindExeception extends BaseException {

    private Integer code;

    private String msg;

    public ServerNotFindExeception(){
        super(500,"服务没有发现");
    }

}
