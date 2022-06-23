package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.CreateStudentRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
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
    protected boolean isValidatedRequest(CreateStudentRequest request) {
        Student student = request.getData();
        try {
            if(student == null || student.getName() == null || student.getName().isEmpty()
                    || student.getPersonClass() == null ||  student.getPersonClass().isEmpty()){
                return false;
            }
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
