package xyz.javaboy.register.impl;

import xyz.javaboy.common.ServerParam;
import xyz.javaboy.register.ServerRegister;
import xyz.javaboy.util.SingleFactory;
import xyz.javaboy.util.ZkUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/26
 * @description zookeeper服务注册.
 */
public class ZkServerRegister implements ServerRegister {


    private ZkUtils zkUtils = SingleFactory.getInstance(ZkUtils.class);

    @Override
    public boolean register(ServerParam serverParam) {
        boolean isSuccess = false;
        ObjectOutputStream oos = null;
       try{
           String serverName = serverParam.serverName();
           ByteArrayOutputStream outputStream=new ByteArrayOutputStream();

           oos = new ObjectOutputStream(outputStream);
           oos.writeObject(serverParam);
           byte[] bytes = outputStream.toByteArray();

           zkUtils.register(serverName, bytes);
           isSuccess = true;
       }catch (Exception e){
           e.printStackTrace();
           isSuccess = false;
       }finally {
           if(oos!=null){
               try {
                   oos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           return isSuccess;
       }
    }


    @Override
    public List<ServerParam> find(String serverName) {
        List<ServerParam> result = new ArrayList<>();
        try {
            List<String> paths = zkUtils.findChildrens(serverName);

            if(paths==null || paths.size()<1){
                return result;
            }
            Iterator<String> iterator = paths.iterator();
            while (iterator.hasNext()){
                String path = iterator.next();
                byte[] bytes = zkUtils.findByPath(path);
                ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(inputStream);

                Object object = ois.readObject();
                if(object instanceof ServerParam){
                    result.add(ServerParam.class.cast(object));
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        ZkServerRegister zkServerRegister = new ZkServerRegister();
        ServerParam server = ServerParam.buildServer(
                ServerRegister.class, ZkServerRegister.class, "version1.0", "g1.0");
        boolean isSuccess = zkServerRegister.register(server);
        if(!isSuccess){
            System.out.println("服务注册失败");
            return;
        }
        System.out.println("服务注册成功");

        zkServerRegister = new ZkServerRegister();
        List<ServerParam> serverParam = zkServerRegister.find(server.serverName());

        System.out.println(serverParam);
    }
}
