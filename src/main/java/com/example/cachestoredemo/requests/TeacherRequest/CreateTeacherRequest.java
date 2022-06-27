package com.example.cachestoredemo.requests.TeacherRequest;

import com.example.cachestoredemo.entities.Teacher;
import com.example.cachestoredemo.requests.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTeacherRequest extends BaseRequest<Teacher> {
    public CreateTeacherRequest(Teacher data) {
        super(data);
    }
}
