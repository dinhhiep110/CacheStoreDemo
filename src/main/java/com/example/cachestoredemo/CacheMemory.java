package com.example.cachestoredemo;


import com.example.cachestoredemo.Dao.PointRedisImpl;
import com.example.cachestoredemo.Until.Const;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheMemory {

    public static Map<String,Integer> map = new ConcurrentHashMap<>();
    public static void initCache(){
        map = new PointRedisImpl().getPoints(Const.POINT_KEY);
    }
    public static void update(Map<String,Integer> points){
        map = points;
    }

    public static Map<String,Integer> get(){
        if(map == null || map.isEmpty()){
            return new ConcurrentHashMap<>();
        }
        return map;
    }

    public static boolean isPointExisted(String point){
        return map.containsKey(point);
    }

}
