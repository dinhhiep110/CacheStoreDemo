package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.DeleteStudentRequest;
import com.example.cachestoredemo.Respond.StudentRespond;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentDeleteApi extends BaseApi<DeleteStudentRequest,StudentRespond> {


    @Override
    protected StudentRespond execute(DeleteStudentRequest request) {
        int id = request.getData();
        Student student = studentService.getStudentById(id);
        studentService.deleteStudent(id);
        return new StudentRespond("Delete Successfully",student);
    }

    @Override
    protected boolean isValidatedRequest(DeleteStudentRequest request) {
        try{
            int id = request.getData();
            Student student = studentService.getStudentById(id);
            if (Objects.isNull(student)) {
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
