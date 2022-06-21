package com.example.cachestoredemo.Controller;

import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping()
    public ResponseEntity<?> addStudent(@Validated @RequestBody Student student){
        try{
            if(student == null){
                return new ResponseEntity<>("Add UnSuccessfully", HttpStatus.BAD_REQUEST);
            }
            Student newStudent = new Student(student.getName(),student.getPersonClass(),student.getTotalPoints());
            studentService.addStudent(student);
            return new ResponseEntity<>("Add Successfully",HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Add UnSuccessfully", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @Validated @RequestBody Student student){
        try {
            if(student == null){
                return new ResponseEntity<>("Student is not existed", HttpStatus.BAD_REQUEST);
            }
            Student oldStudent = studentService.getStudentById(id);
            student.setId(oldStudent.getId());
            student.setName((student.getName() == null) ? oldStudent.getName() : student.getName());
            student.setTotalPoints(oldStudent.getTotalPoints());
            student.setPersonClass((student.getPersonClass() == null) ? oldStudent.getPersonClass() : student.getPersonClass());
            studentService.updateStudent(student);
            return new ResponseEntity<>("Update Successfully",HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Update UnSuccessfully", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllStudents(){
        try{
            List<Student> students = studentService.getStudents();
            if(students.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else if (Objects.isNull(students)) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(students,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        try{
            Student student = studentService.getStudentById(id);
            if (Objects.isNull(student)) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        try{
            Student student = studentService.getStudentById(id);
            if (Objects.isNull(student)) {
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
            studentService.deleteStudent(id);
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}