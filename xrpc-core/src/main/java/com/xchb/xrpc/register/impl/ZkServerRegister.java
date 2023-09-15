package com.xchb.xrpc.register.impl;

import com.xchb.xrpc.common.AppConst;
import com.xchb.xrpc.common.ServerParam;
import com.xchb.xrpc.register.ServerRegister;
import com.xchb.xrpc.util.SingleFactory;
import com.xchb.xrpc.util.ZkUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/26
 * @description zookeeper服务注册.
 */
@Slf4j
public class ZkServerRegister implements ServerRegister {



    private Queue<ServerParam> taskQueue = new LinkedBlockingQueue<>();

    @Override
    public boolean register() {
        while (!taskQueue.isEmpty()){
            ServerParam serverParam = taskQueue.poll();
            serverParam.setPort(AppConst.exportPort);
            ObjectOutputStream oos = null;
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                String serverName = serverParam.serverName();
                oos = new ObjectOutputStream(outputStream);
                oos.writeObject(serverParam);
                byte[] bytes = outputStream.toByteArray();
                ZkUtils zkUtils = SingleFactory.getInstance(ZkUtils.class);
                zkUtils.register(serverName, bytes);
                log.info("服务注册成功：{}",serverParam);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    @Override
    public List<ServerParam> find(String serverName) {
        List<ServerParam> result = new ArrayList<>();
        ZkUtils zkUtils = SingleFactory.getInstance(ZkUtils.class);
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

    @Override
    public void put(ServerParam serverParam) {
        taskQueue.offer(serverParam);
    }

    @Override
    public Integer serverCount() {
        return taskQueue.size();
    }


}
