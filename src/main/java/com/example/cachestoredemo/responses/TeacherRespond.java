package com.example.cachestoredemo.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRespond extends BaseRespond{
    private final Object data;

    public TeacherRespond(String message, Object data) {
        super(message);
        this.data = data;
    }
}
