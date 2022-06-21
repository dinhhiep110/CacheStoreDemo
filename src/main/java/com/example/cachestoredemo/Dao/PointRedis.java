package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Until.Const;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PointRedis extends BaseRedis{
    public Map<String,Integer> getPoints(String key){
       //TODO convert Map<String,String> to Map<String,Int>;
        Map<String,Integer> map = new ConcurrentHashMap<>();
        for (String keys : getAll(key).keySet()) {
            map.put(key,Integer.parseInt(getAll(key).get(keys)));
        }
        return map;
    }

    public void setPoints(String key,String field,String value){
        set(key, field, value);
    }
}
