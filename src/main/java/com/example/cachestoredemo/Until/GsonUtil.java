package com.example.cachestoredemo.Until;

import com.example.cachestoredemo.Entity.Student;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GsonUtil {

    private static Gson gson = new Gson();
    public static Object convertToObject(String stringObject){
        return gson.fromJson(stringObject, Student.class);
        //TODO not student > T.class
    }
    public static String covertFromObject(Object object){
        return gson.toJson(object);
    }
}
