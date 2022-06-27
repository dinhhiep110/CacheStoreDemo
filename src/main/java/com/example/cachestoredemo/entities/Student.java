package com.example.cachestoredemo.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    @NonNull
    private int totalPoints;

    public Student(String name, String personClass, int totalPoints) {
        super(name, personClass);
        this.totalPoints = totalPoints;
    }
}
