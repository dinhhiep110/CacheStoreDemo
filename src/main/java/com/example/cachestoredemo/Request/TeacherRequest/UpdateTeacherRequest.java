package com.example.cachestoredemo.Request.TeacherRequest;

import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTeacherRequest extends BaseRequest<Teacher> {
    private String id;

    public UpdateTeacherRequest(Teacher data,String id) {
        super(data);
        this.id = id;
    }
}
