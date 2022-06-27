package com.example.cachestoredemo.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointRespond extends BaseRespond{
    private final Object data;

    public PointRespond(String message, Object data) {
        super(message);
        this.data = data;
    }
}
