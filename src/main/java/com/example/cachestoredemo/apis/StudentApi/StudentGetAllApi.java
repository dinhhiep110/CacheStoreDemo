package com.example.cachestoredemo.apis.StudentApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.StudentRequest.GetAllStudentRequest;
import com.example.cachestoredemo.responses.StudentRespond;
import com.example.cachestoredemo.utils.Util;
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
