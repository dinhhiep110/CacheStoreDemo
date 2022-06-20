package com.example.cachestoredemo.Entity;

public class Student extends Person {

    private final int totalGrade;

    public Student(String name, String personClass, int totalGrade) {
        super(name, personClass);
        this.totalGrade = totalGrade;
    }
}
