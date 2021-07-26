package com.xchb.xrpc.util;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
public class AppConst {

    public static final Integer SERVER_PORT = 8770;

    public static final String ZK_CONNECTION_INFO = "localhost:2181";

    public static String SERVER_IP = null;

    static {
        SERVER_IP = IpUtils.localIP();
    }

}
