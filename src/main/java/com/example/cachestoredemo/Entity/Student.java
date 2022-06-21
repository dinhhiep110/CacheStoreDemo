package com.example.cachestoredemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    private int totalPoints;

    public Student(String name, String personClass, int totalPoints) {
        super(name, personClass);
        this.totalPoints = totalPoints;
    }
}
