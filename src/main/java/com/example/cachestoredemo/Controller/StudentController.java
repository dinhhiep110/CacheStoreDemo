package com.example.cachestoredemo.Controller;

import com.example.cachestoredemo.Api.StudentApi.*;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.StudentRequest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentCreateApi studentCreateApi;

    @Autowired
    StudentUpdateApi studentUpdateApi;

    @Autowired
    StudentGetAllApi studentGetAllApi;

    @Autowired
    StudentGetByIdApi studentGetByIdApi;

    @Autowired
    StudentDeleteApi studentDeleteApi;

    @PostMapping()
    public ResponseEntity<?> addStudent(@Validated @RequestBody Student student){
        return studentCreateApi.doExecute(new CreateStudentRequest(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@Validated @PathVariable int id, @Validated @RequestBody Student student){
        student.setId(id);
        return studentUpdateApi.doExecute(new UpdateStudentRequest(student));
    }

    @GetMapping()
    public ResponseEntity<?> getAllStudents(){
        return studentGetAllApi.doExecute(new GetAllStudentRequest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@Validated @PathVariable int id){
        return studentGetByIdApi.doExecute(new GetStudentByIdRequest(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@Validated @PathVariable int id){
        return studentDeleteApi.doExecute(new DeleteStudentRequest(id));
    }
}