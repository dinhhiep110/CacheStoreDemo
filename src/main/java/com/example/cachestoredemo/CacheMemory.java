package com.example.cachestoredemo;

import com.example.cachestoredemo.Dao.PointRedis;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheMemory {
    static Map<String,Integer> map = new ConcurrentHashMap<>();

    @Autowired
    PointRedis pointRedis;

    public static void add(Map<String,String> points){
        for (String key: points.keySet()) {
            map.put(key,Integer.parseInt(points.get(key)));
        }
    }

    public static Map<String,Integer> get(){
        if(map == null || map.isEmpty()){
            return null;
        }
        return map;
    }
}
