package xyz.javaboy.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
public class AppConst {

    public static final Integer SERVER_PORT = 8770;

    public static final String ZK_CONNECTION_INFO = "192.168.134.148:2181";


    public static String SERVER_IP = null;

    static {
        try {
            SERVER_IP = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
