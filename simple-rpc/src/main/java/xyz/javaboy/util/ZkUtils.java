package xyz.javaboy.util;

import cn.hutool.core.util.CharsetUtil;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
public class ZkUtils {

    private final static String ROOT_PATH = "/rpc-demo";

    private CuratorFramework client;



    public ZkUtils() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        this.client = CuratorFrameworkFactory.newClient(AppConst.ZK_CONNECTION_INFO, retryPolicy);
        client.start();
        Stat stat = client.checkExists().forPath(ROOT_PATH);
        if(stat==null){
            client.create().forPath(ROOT_PATH);
        }
    }

    public boolean registerServer(String serverName,String value) {
        try {
            String path = ROOT_PATH+"/"+serverName;
            if(client.checkExists().forPath(path)!=null){
                client.delete().forPath(path);
            }
            client.create().forPath(path,value.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String findServer(String path) {
        try {
            path = ROOT_PATH+"/"+path;
            System.out.println("path = "+path);
            byte[] bytes = client.getData().forPath(path);
            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        ZkUtils zkUtils = new ZkUtils();

        zkUtils.registerServer("13241", "1234");
    }

}
