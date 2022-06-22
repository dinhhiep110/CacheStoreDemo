package com.example.cachestoredemo.Request.StudentRequest;

import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest extends BaseRequest<Student> {
    public CreateStudentRequest(Student data) {
        super(data);
    }
}
