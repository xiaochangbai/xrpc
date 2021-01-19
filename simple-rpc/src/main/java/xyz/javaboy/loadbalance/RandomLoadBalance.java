package xyz.javaboy.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * @author XDD
 * @project rpc-demo
 * @date 2021/1/19
 * @description 随机的方式实现.
 */
public class RandomLoadBalance implements LoadBalance {

    private Random random;

    public RandomLoadBalance(){
        this.random = new Random();
    }

    @Override
    public Class<?> load(List<Class<?>> serverClass) {
        if(serverClass==null){
            return null;
        }
        return serverClass.get(generatorIndex(serverClass.size()));
    }

    private int generatorIndex(int size) {
        return random.nextInt(size);
    }

    public static void main(String[] args) {
        RandomLoadBalance randomLoadBalance = new RandomLoadBalance();
        for (int i=0;i<20;i++){
            System.out.println(randomLoadBalance.generatorIndex(6));
        }
    }
}
