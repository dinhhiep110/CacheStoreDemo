package com.example.cachestoredemo.Dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PointRedis extends BaseRedis{
    public Map<String,String> getPoints(String key){
        return getAll(key);
    }

    public void setPoints(String key,String field,String value){
        set(key, field, value);
    }
}
