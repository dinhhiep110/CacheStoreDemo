package com.example.cachestoredemo.apis.StudentApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.StudentRequest.CreateStudentRequest;
import com.example.cachestoredemo.responses.StudentRespond;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentCreateApi extends BaseApi<CreateStudentRequest,StudentRespond> {

    @Override
    protected StudentRespond execute(CreateStudentRequest request) {
        Student student = request.getData();
        Student newStudent = new Student(student.getName(),student.getPersonClass(),student.getTotalPoints());
        studentService.addStudent(newStudent);
        return new StudentRespond("Add Successfully",newStudent);
    }

    @Override
    protected HttpStatus validateRequest(CreateStudentRequest request) {
        return HttpStatus.OK;
    }
}
