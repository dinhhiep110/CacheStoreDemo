package com.example.cachestoredemo.Entity;

public class Teacher extends Person{
    private final String subject;

    public Teacher(String name, String personClass, String subject) {
        super(name, personClass);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
