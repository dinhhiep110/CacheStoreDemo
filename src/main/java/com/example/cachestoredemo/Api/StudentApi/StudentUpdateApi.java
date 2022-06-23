package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.UpdateStudentRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import org.springframework.stereotype.Component;

@Component
public class StudentUpdateApi extends BaseApi<UpdateStudentRequest,StudentRespond> {

    @Override
    protected StudentRespond execute(UpdateStudentRequest request) {
        Student student = request.getData();
        Student oldStudent = studentService.getStudentById(student.getId());
        student.setId(oldStudent.getId());
        student.setName((student.getName() == null) ? oldStudent.getName() : student.getName());
        student.setPersonClass((student.getPersonClass() == null) ? oldStudent.getPersonClass() : student.getPersonClass());
        studentService.updateStudent(student);
        return new StudentRespond("Update Successfully",student);
    }

    @Override
    protected boolean isValidatedRequest(UpdateStudentRequest request) {
        Student student = request.getData();
        try {
            Student oldStudent = studentService.getStudentById(student.getId());
            if(oldStudent == null){
                return false;
            }
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
