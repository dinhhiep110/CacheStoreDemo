package com.example.cachestoredemo.Services;

import com.example.cachestoredemo.Entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void updateStudent(Student student);

    List<Student> getStudents();

    Student getStudentById(String id);

    void deleteStudent(String id);
}
