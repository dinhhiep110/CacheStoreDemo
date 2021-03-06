package com.example.cachestoredemo.controller;

import com.example.cachestoredemo.apis.TeacherApi.*;
import com.example.cachestoredemo.entities.Teacher;
import com.example.cachestoredemo.requests.TeacherRequest.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    @Autowired
    TeacherCreateApi teacherCreateApi;

    @Autowired
    TeacherUpdateApi teacherUpdateApi;

    @Autowired
    TeacherGetAllApi teacherGetAllApi;

    @Autowired
    TeacherGetByIdApi teacherGetByIdApi;

    @Autowired
    TeacherDeleteApi teacherDeleteApi;
    @PostMapping()
    public ResponseEntity<?> addTeacher(@Validated @NonNull @RequestBody Teacher teacher){
        return   teacherCreateApi.doExecute(new CreateTeacherRequest(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable String id, @Validated @RequestBody Teacher teacher){
        return teacherUpdateApi.doExecute(new UpdateTeacherRequest(teacher,id));
    }

    @GetMapping()
    public ResponseEntity<?> getAllTeachers(){
        return teacherGetAllApi.doExecute(new GetAllTeacherRequest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@NonNull @Validated @PathVariable String id){
        return teacherGetByIdApi.doExecute(new GetTeacherByIdRequest(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@NonNull @Validated @PathVariable String id){
        return teacherDeleteApi.doExecute(new DeleteTeacherRequest(id));
    }
}
