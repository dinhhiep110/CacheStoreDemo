package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.GetStudentByIdRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import com.example.cachestoredemo.Until.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentGetByIdApi extends BaseApi<GetStudentByIdRequest,StudentRespond> {
    @Override
    protected StudentRespond execute(GetStudentByIdRequest request) {
        String id = request.getData();
        Student student = studentService.getStudentById(id);
        return new StudentRespond("Find Student Successfully",student);
    }

    @Override
    protected HttpStatus validateRequest(GetStudentByIdRequest request) {
        try{
            String id = request.getData();
            Student student = studentService.getStudentById(id);
             if(Util.isNull(student)){
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
