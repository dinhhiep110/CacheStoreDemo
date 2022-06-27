package com.example.cachestoredemo.apis.StudentApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.StudentRequest.UpdateStudentRequest;
import com.example.cachestoredemo.responses.StudentRespond;
import com.example.cachestoredemo.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentUpdateApi extends BaseApi<UpdateStudentRequest,StudentRespond> {

    @Override
    protected StudentRespond execute(UpdateStudentRequest request) {
        Student student = request.getData();
        Student oldStudent = studentService.getStudentById(student.getId());
        String oldId = oldStudent.getId();
        student.setId(oldId);
        String studentName = student.getName();
        String oldStudentName = oldStudent.getName();
        String name = (Util.isNull(studentName)) ? oldStudentName : studentName;
        student.setName(name);
        String studentClass = student.getPersonClass();
        String oldStudentClass = oldStudent.getPersonClass();
        String Class = (Util.isNull(studentClass)) ? oldStudentClass : studentClass;
        student.setPersonClass(Class);
        studentService.updateStudent(student);
        return new StudentRespond("Update Successfully",student);
    }

    @Override
    protected HttpStatus validateRequest(UpdateStudentRequest request) {
        try {
            Student student = request.getData();
            Student oldStudent = studentService.getStudentById(student.getId());
            if(Util.isNull(oldStudent)){
                return HttpStatus.BAD_REQUEST;
            }
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return HttpStatus.UNPROCESSABLE_ENTITY;
        }
        return HttpStatus.OK;
    }
}
