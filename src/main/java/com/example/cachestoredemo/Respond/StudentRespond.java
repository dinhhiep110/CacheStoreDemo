package com.example.cachestoredemo.Respond;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentRespond extends BaseRespond{
    private final Object data;

    public StudentRespond(String message, Object data) {
        super(message);
        this.data = data;
    }
}
