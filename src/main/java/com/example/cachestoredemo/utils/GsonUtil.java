package com.example.cachestoredemo.utils;
import com.google.gson.Gson;


public abstract class GsonUtil<T> {

    protected final Gson gson = new Gson();
    public abstract T convertToObject(String stringObject);

    public abstract String covertFromObject(Object object);
}
