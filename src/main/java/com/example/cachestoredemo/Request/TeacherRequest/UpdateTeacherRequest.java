package com.example.cachestoredemo.Request.TeacherRequest;

import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTeacherRequest extends BaseRequest<Teacher> {
    private int tid;

    public UpdateTeacherRequest(Teacher data, int tid) {
        super(data);
        this.tid = tid;
    }
}
