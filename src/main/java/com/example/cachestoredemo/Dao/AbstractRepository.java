package com.example.cachestoredemo.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T> extends BaseRedis{
    protected abstract T convertToEntity(String string);

    protected abstract String convertToDatabaseObject(T entity);

    public void insert(T entity,String key,String field){
        String databaseObject = convertToDatabaseObject(entity);
        set(key,field,databaseObject);
    }

    public T getEntityById(String field,String key) {
        String entity = get(key, field);
        return convertToEntity(entity);
    }

    public List<T> getAllEntity(String key){
        Map<String, String> mapEntities = getAll(key);
        List<T> listEntities = new ArrayList<>();
        for (String keys : mapEntities.keySet()) {
            listEntities.add(convertToEntity(mapEntities.get(keys)));
        }
        return listEntities;
    }

    public void deleteEntity(String key,String filed){
        delete(key,filed);
    }
}