package com.xchb.xrpc.loadbalance.impl;

import com.xchb.xrpc.loadbalance.LoadBalance;

import java.util.List;
import java.util.Random;

/**
 * @author XDD
 * @project xrpc
 * @date 2021/1/19
 * @description 随机的方式实现.
 */
public class RandomLoadBalance implements LoadBalance {

    private Random random;

    public RandomLoadBalance(){
        this.random = new Random();
    }

    @Override
    public <T> T load(List<T> objs) {
        if(objs==null){
            return null;
        }
        return objs.get(generatorIndex(objs.size()));
    }

    private int generatorIndex(int size) {
        return random.nextInt(size);
    }


}
