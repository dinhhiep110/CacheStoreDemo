package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.DeleteStudentRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import com.example.cachestoredemo.Until.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class StudentDeleteApi extends BaseApi<DeleteStudentRequest,StudentRespond> {


    @Override
    protected StudentRespond execute(DeleteStudentRequest request) {
        String id = request.getData();
        Student studentDeleted = studentService.getStudentById(id);
        studentService.deleteStudent(id);
        return new StudentRespond("Delete Successfully",studentDeleted);
    }

    @Override
    protected HttpStatus validateRequest(DeleteStudentRequest request) {
        try{
            String id = request.getData();
            Student student = studentService.getStudentById(id);
            if (Util.isNull(student)) {
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
