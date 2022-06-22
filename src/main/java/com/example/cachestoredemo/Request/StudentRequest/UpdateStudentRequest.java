package com.example.cachestoredemo.Request.StudentRequest;

import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequest extends BaseRequest<Student> {
    public UpdateStudentRequest(Student data) {
        super(data);
    }
}
