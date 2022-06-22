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
public class StudentUpdateApi extends BaseApi {
    @Autowired
    StudentService studentService;
    @Override
    protected ResponseEntity<BaseRespond> execute(BaseRequest request) {
        Student student = (Student) request.getData();
        try {
            Student oldStudent = studentService.getStudentById(student.getId());
            if(student == null || oldStudent == null){
                return new ResponseEntity<>(new StudentRespond("Student is not existed",null), HttpStatus.BAD_REQUEST);
            }
            student.setId(oldStudent.getId());
            student.setName((student.getName() == null) ? oldStudent.getName() : student.getName());
            student.setPersonClass((student.getPersonClass() == null) ? oldStudent.getPersonClass() : student.getPersonClass());
            studentService.updateStudent(student);
            return new ResponseEntity<>(new StudentRespond("Update Successfully",student),HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new StudentRespond("Update UnSuccessfully",new Student()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    protected boolean isValidatedRequest(BaseRequest request) {
        try {

        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
