package com.example.cachestoredemo.Dao;

import com.google.gson.Gson;

public interface GsonConvert<T> {
    String convertToString(T t);

    T convertToObject(String string);
}
