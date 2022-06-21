package com.example.cachestoredemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person{
    private String subject;

    public Teacher(String name, String personClass, String subject) {
        super(name, personClass);
        this.subject = subject;
    }
}
