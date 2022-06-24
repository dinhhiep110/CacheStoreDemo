package com.example.cachestoredemo.Entity;

import com.example.cachestoredemo.Until.Util;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String personClass;

    public Person(String name, String personClass) {
        this.id = Util.getRandomUUID();
        this.name = name;
        this.personClass = personClass;
    }

}
