package com.example.cachestoredemo.dao;

import java.util.Map;

public interface PointRedis{
    Map<String,Integer> getPoints(String key);

    void setPoints(String key,String field,String value);
}
