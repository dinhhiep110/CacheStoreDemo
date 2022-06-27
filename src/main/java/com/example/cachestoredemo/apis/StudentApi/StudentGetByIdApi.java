package com.example.cachestoredemo.apis.StudentApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.StudentRequest.GetStudentByIdRequest;
import com.example.cachestoredemo.responses.StudentRespond;
import com.example.cachestoredemo.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

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
