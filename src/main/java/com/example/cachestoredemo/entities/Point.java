package com.example.cachestoredemo.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    @NonNull
    private String name;
    @NonNull
    private int value;
}
