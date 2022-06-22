package com.example.cachestoredemo.Respond;

import com.example.cachestoredemo.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class StudentRespond extends BaseRespond{
    public StudentRespond(String message, Object data) {
        super(message, data);
    }
}
