package com.example.cachestoredemo.Entity;

import com.example.cachestoredemo.Until.Const;
import com.example.cachestoredemo.Until.PersonUntil;

public class Person {
    private final int id;
    private final String name;
    private final String personClass;

    public Person(String name, String personClass) {
        this.id = PersonUntil.getRandomInteger(Const.MAX_ID);
        this.name = name;
        this.personClass = personClass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPersonClass() {
        return personClass;
    }
}
