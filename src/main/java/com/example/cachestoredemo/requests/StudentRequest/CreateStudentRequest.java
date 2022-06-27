package com.example.cachestoredemo.requests.StudentRequest;

import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest extends BaseRequest<Student> {
    public CreateStudentRequest(Student data) {
        super(data);
    }

}
