package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.GetAllStudentRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentGetAllApi extends BaseApi<GetAllStudentRequest,StudentRespond> {

    @Override
    protected StudentRespond execute(GetAllStudentRequest request) {
        List<Student> students = studentService.getStudents();
        return new StudentRespond("List Students",students);
    }

    @Override
    protected boolean isValidatedRequest(GetAllStudentRequest request) {
        try{
            List<Student> students = studentService.getStudents();
            return !students.isEmpty();
        }
        catch (Exception e){
            return false;
        }
    }
}
