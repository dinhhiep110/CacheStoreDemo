package com.example.cachestoredemo.dao;

import com.example.cachestoredemo.entities.Student;

import java.util.List;

public interface StudentRedis {
    void setStudent(Student student);

    Student getStudentById(String id);

    List<Student> getStudents();

    void deleteStudent(String id);
}
