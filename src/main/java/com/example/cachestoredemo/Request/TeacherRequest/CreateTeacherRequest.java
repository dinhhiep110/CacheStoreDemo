package com.example.cachestoredemo.Request.TeacherRequest;

import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTeacherRequest extends BaseRequest<Teacher> {
    public CreateTeacherRequest(Teacher data) {
        super(data);
    }
}
