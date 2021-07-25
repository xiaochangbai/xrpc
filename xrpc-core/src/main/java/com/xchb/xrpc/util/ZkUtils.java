package com.xchb.xrpc.util;

import cn.hutool.core.util.IdUtil;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/15
 * @description Good Good Study,Day Day Up.
 */
public class ZkUtils {

    private final static String ROOT_PATH = "/xrpc";

    private CuratorFramework client;

    public ZkUtils() throws Exception {
        //重试策略
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
            return this.register(serverName, value.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean register(String serverName,byte[] values) {
        try {
            String path = ROOT_PATH+"/"+serverName;
            if(client.checkExists().forPath(path)==null){
                client.create().forPath(path);
            }
            path+="/"+IdUtil.simpleUUID();
            if(client.checkExists().forPath(path)!=null){
                client.delete().forPath(path);
            }
            //创建临时节点
            client.create().withMode(CreateMode.EPHEMERAL).forPath(path,values);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public String findServer(String path) throws UnsupportedEncodingException {
        byte[] bytes = this.find(path);
        return new String(bytes,"UTF-8");
    }

    public byte[] find(String path) {
        return this.findByPath(ROOT_PATH+"/"+path);
    }

    public List<String> findChildrens(String serverName) {
        String path = ROOT_PATH+"/"+serverName;
        try {
            List<String> list = client.getChildren().forPath(path);
            if(list==null || list.size()<1){
                return null;
            }
            List<String> result = list.stream().map(e -> {
                return ROOT_PATH + "/" + serverName + "/" + e;
            }).collect(Collectors.toList());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] findByPath(String path) {
        try {
            return client.getData().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
