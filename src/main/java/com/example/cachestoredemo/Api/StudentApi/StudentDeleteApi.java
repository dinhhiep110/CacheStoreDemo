package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.BaseRequest;
import com.example.cachestoredemo.Respond.BaseRespond;
import com.example.cachestoredemo.Respond.StudentRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentDeleteApi extends BaseApi {

    @Override
    protected ResponseEntity<BaseRespond> execute(BaseRequest request) {
        try{
            int id = (int) request.getData();
            Student student = studentService.getStudentById(id);
            if (Objects.isNull(student)) {
                return new ResponseEntity<>(new StudentRespond("Student is not existed",null), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            studentService.deleteStudent(id);
            return new ResponseEntity<>(new StudentRespond("Delete Successfully",student),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new StudentRespond("Delete Failed",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected boolean isValidatedRequest(BaseRequest request) {
        try {

        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
