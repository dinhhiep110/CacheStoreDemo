package com.example.cachestoredemo.utils;

import com.example.cachestoredemo.entities.Teacher;

public class GsonTeacherUtil extends GsonUtil<Teacher> {
    @Override
    public Teacher convertToObject(String stringObject) {
        return gson.fromJson(stringObject, Teacher.class);
    }

    @Override
    public String covertFromObject(Object object) {
        return gson.toJson(object);
    }
}
