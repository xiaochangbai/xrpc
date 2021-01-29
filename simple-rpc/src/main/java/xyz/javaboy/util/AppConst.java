package xyz.javaboy.util;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/10
 * @description Good Good Study,Day Day Up.
 */
public class AppConst {

    public static final Integer SERVER_PORT = 8770;

    public static final String ZK_CONNECTION_INFO = "127.0.0.1:8181";


    public static String SERVER_IP = null;

    static {
        SERVER_IP = IpUtils.localIP();
    }

}
