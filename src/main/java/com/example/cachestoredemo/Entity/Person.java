package com.example.cachestoredemo.Entity;

import com.example.cachestoredemo.Until.Const;
import com.example.cachestoredemo.Until.PersonUntil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private String personClass;

    public Person(String name, String personClass) {
        this.id = PersonUntil.getRandomInteger(Const.MAX_ID);
        this.name = name;
        this.personClass = personClass;
    }

}
