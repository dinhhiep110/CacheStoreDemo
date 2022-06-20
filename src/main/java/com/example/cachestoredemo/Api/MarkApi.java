package com.example.cachestoredemo.Api;

import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping("/api/grades")
public class GradeApi {
    @Autowired
    StudentService studentService;

    static Map<String,Integer> map = CacheMemory.get();

    @GetMapping("/grade")
    public ResponseEntity<?> markGrade(@PathVariable String grade){
        if(map == null || map.isEmpty()){
            return ResponseEntity<>("Cannot mark grade")
        }
    }
}
