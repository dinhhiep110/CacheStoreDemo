package com.example.cachestoredemo.Respond;

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
