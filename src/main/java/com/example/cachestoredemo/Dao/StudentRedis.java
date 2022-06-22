package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRedis {
    void setStudent(Student student);

    Student getStudentById(int id);

    List<Student> getStudents();

    void deleteStudent(int id);
}
