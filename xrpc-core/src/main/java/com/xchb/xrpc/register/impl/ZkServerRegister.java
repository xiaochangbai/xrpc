package com.xchb.xrpc.register.impl;

import com.xchb.xrpc.register.ServerRegister;
import com.xchb.xrpc.util.SingleFactory;
import com.xchb.xrpc.common.ServerParam;
import com.xchb.xrpc.util.ZkUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/26
 * @description zookeeper服务注册.
 */
public class ZkServerRegister implements ServerRegister {


    private ZkUtils zkUtils = SingleFactory.getInstance(ZkUtils.class);

    @Override
    public boolean register(ServerParam serverParam) {
        ObjectOutputStream oos = null;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            String serverName = serverParam.serverName();
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(serverParam);
            byte[] bytes = outputStream.toByteArray();
            zkUtils.register(serverName, bytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<ServerParam> find(String serverName) {
        List<ServerParam> result = new ArrayList<>();
        List<String> paths = zkUtils.findChildrens(serverName);
        if (paths == null || paths.size() < 1) {
            return result;
        }
        for (String path : paths) {
            byte[] bytes = zkUtils.findByPath(path);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            try (ObjectInputStream ois = new ObjectInputStream(inputStream)) {
                Object object = ois.readObject();
                if (object instanceof ServerParam) {
                    result.add((ServerParam) object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        ZkServerRegister zkServerRegister = new ZkServerRegister();
        ServerParam server = ServerParam.buildServer(
                ServerRegister.class, ZkServerRegister.class, "version1.0", "g1.0");
        boolean isSuccess = zkServerRegister.register(server);
        if (!isSuccess) {
            System.out.println("服务注册失败");
            return;
        }
        System.out.println("服务注册成功");

        zkServerRegister = new ZkServerRegister();
        List<ServerParam> serverParam = zkServerRegister.find(server.serverName());

        System.out.println(serverParam);
    }
}
