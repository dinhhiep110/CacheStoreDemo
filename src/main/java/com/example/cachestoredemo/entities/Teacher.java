package com.example.cachestoredemo.entities;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person{
    @NonNull
    private String subject;

    public Teacher(String name, String personClass, String subject) {
        super(name, personClass);
        this.subject = subject;
    }
}
