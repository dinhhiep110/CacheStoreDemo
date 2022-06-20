package com.example.cachestoredemo.Services;

import com.example.cachestoredemo.Entity.Student;

import java.util.List;

public interface StudentServices {
    void addStudent(Student student);

    void updateStudent(Student student);

    List<Student> getStudents();

    Student getStudentById(int id);

    void deleteStudent(int id);
}
