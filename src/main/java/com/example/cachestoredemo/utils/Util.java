package com.example.cachestoredemo.utils;

import java.util.UUID;

public class Util {
    public static String getRandomUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0,4);
    }

    public static boolean isNull(Object object){
        return object == null;
    }
}
