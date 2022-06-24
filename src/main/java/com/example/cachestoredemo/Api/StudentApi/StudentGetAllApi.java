package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.GetAllStudentRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import com.example.cachestoredemo.Until.Util;
import org.springframework.http.HttpStatus;
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
    protected HttpStatus validateRequest(GetAllStudentRequest request) {
        try{
            List<Student> students = studentService.getStudents();
            if(Util.isNull(students) || students.isEmpty()){
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
