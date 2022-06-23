package com.example.cachestoredemo.Dao;

import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class PointRedisImpl extends BaseRedis implements PointRedis{

    Gson gson = new Gson();
    public Map<String,Integer> getPoints(String key){
       //TODO convert Map<String,String> to Map<String,Int>;
        Map<String,Integer> map = new ConcurrentHashMap<>();
        for (String k : getAll(key).keySet()) {
            map.put(k,Integer.parseInt(getAll(key).get(k)));
        }
        return map;
    }
    public void setPoints(String key,String field,String value){
        set(key, field, value);
    }
}
