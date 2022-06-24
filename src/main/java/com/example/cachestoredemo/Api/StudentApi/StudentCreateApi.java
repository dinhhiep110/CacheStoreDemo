package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.CreateStudentRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import com.example.cachestoredemo.Until.Util;
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
        try {
            Student student = request.getData();
            String studentName = student.getName();
            String studentClass = student.getPersonClass();
            if(Util.isNull(student) || Util.isNull(studentName) || Util.isNull(studentClass)){
                return HttpStatus.BAD_REQUEST;
            }
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return HttpStatus.NOT_ACCEPTABLE;
        }
        return HttpStatus.OK;
    }
}
