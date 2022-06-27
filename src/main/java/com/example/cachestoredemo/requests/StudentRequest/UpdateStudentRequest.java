package com.example.cachestoredemo.requests.StudentRequest;

import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequest extends BaseRequest<Student> {
    public UpdateStudentRequest(Student data) {
        super(data);
    }
}
