package com.example.cachestoredemo.utils;
import com.example.cachestoredemo.entities.Student;
import com.google.gson.Gson;


public class GsonUtil {

    private static final Gson gson = new Gson();
    public static <T> T convertToObject(String stringObject,Class<T> clazz){
        return gson.fromJson(stringObject, clazz);
    }

    public static String covertFromObject(Object object){
        return gson.toJson(object);
    }
}
