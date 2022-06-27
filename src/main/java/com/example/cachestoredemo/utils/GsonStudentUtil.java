package com.example.cachestoredemo.utils;

import com.example.cachestoredemo.entities.Student;

public class GsonStudentUtil extends GsonUtil<Student> {
    @Override
    public Student convertToObject(String stringObject) {
        return gson.fromJson(stringObject, Student.class);
    }

    @Override
    public String covertFromObject(Object object) {
        return gson.toJson(object);
    }
}

