package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.GetStudentByIdRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentGetByIdApi extends BaseApi<GetStudentByIdRequest,StudentRespond> {
    @Override
    protected StudentRespond execute(GetStudentByIdRequest request) {
        Student student = studentService.getStudentById(request.getData());
        return new StudentRespond("Find Student Successfully",student);
    }

    @Override
    protected boolean isValidatedRequest(GetStudentByIdRequest request) {
        try{
            Student student = studentService.getStudentById( request.getData());
            return !Objects.isNull(student);
        }
        catch (Exception e){
            return true;
        }
    }
}
