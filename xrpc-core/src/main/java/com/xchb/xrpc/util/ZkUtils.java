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


    public ZkUtils(String zkAddr){
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        client = CuratorFrameworkFactory.newClient(zkAddr, retryPolicy);
        client.start();
        Stat stat = null;
        try {
            stat = client.checkExists().forPath(ROOT_PATH);
            if(stat==null){
                client.create().forPath(ROOT_PATH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean registerServer(String serverName,String value) {
        try {
            return register(serverName, value.getBytes("UTF-8"));
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
        byte[] bytes = find(path);
        return new String(bytes,"UTF-8");
    }

    public byte[] find(String path) {
        return findByPath(ROOT_PATH+"/"+path);
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
