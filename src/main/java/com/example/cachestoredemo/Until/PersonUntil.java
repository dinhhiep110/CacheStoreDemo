package com.example.cachestoredemo.Until;

import java.util.Random;

public class PersonUntil {
    public static int getRandomInteger(int max){
        Random random = new Random();
        return random.nextInt(max);
    }
}
