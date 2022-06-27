package com.example.cachestoredemo.controller;

import com.example.cachestoredemo.apis.StudentApi.*;
import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.StudentRequest.*;
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
    public ResponseEntity<?> updateStudent(@Validated @PathVariable String id, @Validated @RequestBody Student student){
        student.setId(id);
        return studentUpdateApi.doExecute(new UpdateStudentRequest(student));
    }

    @GetMapping()
    public ResponseEntity<?> getAllStudents(){
        return studentGetAllApi.doExecute(new GetAllStudentRequest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@Validated @PathVariable String id){
        return studentGetByIdApi.doExecute(new GetStudentByIdRequest(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@Validated @PathVariable String id){
        return studentDeleteApi.doExecute(new DeleteStudentRequest(id));
    }
}