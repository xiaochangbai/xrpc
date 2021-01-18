package xyz.javaboy.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/18
 * @description Good Good Study,Day Day Up.
 */
public class IpUtils {

    public static String localIP(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
