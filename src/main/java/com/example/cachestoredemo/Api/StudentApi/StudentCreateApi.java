package com.example.cachestoredemo.Api.StudentApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.BaseRequest;
import com.example.cachestoredemo.Respond.BaseRespond;
import com.example.cachestoredemo.Respond.StudentRespond;
import com.example.cachestoredemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentCreateApi extends BaseApi {


    @Override
    protected ResponseEntity<BaseRespond>  execute(BaseRequest request) {
        Student student = (Student) request.getData();
        try{
            if(student == null){
                return new ResponseEntity<>(new StudentRespond("Student is invalid", null),HttpStatus.BAD_REQUEST);
            }
            Student newStudent = new Student(student.getName(),student.getPersonClass(),student.getTotalPoints());
            studentService.addStudent(student);
            return new ResponseEntity<>(new StudentRespond("Add Successfully",student),HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new StudentRespond("Add UnSuccessfully",new Student()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    protected boolean isValidatedRequest(BaseRequest request) {
        Student student = (Student) request.getData();
        try {
            if(student.getName() == null || student.getName().isEmpty()
            || student.getPersonClass() == null ||  student.getPersonClass().isEmpty()){
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return true;
    }
}
