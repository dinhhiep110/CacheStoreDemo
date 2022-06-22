package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.BaseRequest;
import com.example.cachestoredemo.Respond.BaseRespond;
import com.example.cachestoredemo.Respond.StudentRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class StudentGetAllApi extends BaseApi {
    @Override
    protected ResponseEntity<BaseRespond> execute(BaseRequest request) {
        try{
            List<Student> students = studentService.getStudents();
            if(students.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (Objects.isNull(students)) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(new StudentRespond("List Students",students),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected boolean isValidatedRequest(BaseRequest request) {
        return true;
    }
}
