package com.example.cachestoredemo.Until;

import java.util.Random;
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
