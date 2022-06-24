package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Student;

import java.util.List;

public interface StudentRedis {
    void setStudent(Student student);

    Student getStudentById(String id);

    List<Student> getStudents();

    void deleteStudent(String id);
}
