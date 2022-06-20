package com.example.cachestoredemo.Api;

import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/teachers")
public class TeacherApi {
    @Autowired
    TeacherService teacherService;

    @PostMapping()
    public ResponseEntity<?> addTeacher(@Validated @RequestBody Teacher teacher){
        try{
            if(teacher == null){
                return new ResponseEntity<>("Add UnSuccessfully", HttpStatus.BAD_REQUEST);
            }
            Teacher newTeacher = new Teacher(teacher.getName(),teacher.getPersonClass(),teacher.getSubject());
            teacherService.addTeacher(teacher);
            return new ResponseEntity<>("Add Successfully",HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Add UnSuccessfully", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable int id, @Validated @RequestBody Teacher teacher){
        try {
            if(teacher == null){
                return new ResponseEntity<>("Student is not existed", HttpStatus.BAD_REQUEST);
            }
            Teacher oldTeacher = teacherService.getTeacherById(id);
            teacher.setId(oldTeacher.getId());
            teacher.setName((teacher.getName() == null) ? oldTeacher.getName() : teacher.getName());
            teacher.setSubject((teacher.getSubject() == null) ? oldTeacher.getSubject() : teacher.getSubject());
            teacher.setPersonClass((teacher.getPersonClass() == null) ? oldTeacher.getPersonClass() : teacher.getPersonClass());
            teacherService.updateTeacher(teacher);
            return new ResponseEntity<>("Update Successfully",HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Update UnSuccessfully", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllTeachers(){
        try{
            List<Teacher> teachers = teacherService.getTeachers();
            if(teachers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (Objects.isNull(teachers)) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(teachers,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable int id){
        try{
            Teacher teacher = teacherService.getTeacherById(id);
            if (Objects.isNull(teacher)) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(teacher,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        try{
            Teacher teacher = teacherService.getTeacherById(id);
            if (Objects.isNull(teacher)) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            teacherService.deleteTeacher(id);
            return new ResponseEntity<>(teacher,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
