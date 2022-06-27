package com.example.cachestoredemo.requests.TeacherRequest;

import com.example.cachestoredemo.entities.Teacher;
import com.example.cachestoredemo.requests.BaseRequest;
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
