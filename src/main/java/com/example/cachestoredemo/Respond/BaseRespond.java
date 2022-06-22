package com.example.cachestoredemo.Respond;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseRespond<T> {
    private String message;
    private T data;
}
