package com.example.cachestoredemo.services;

import com.example.cachestoredemo.entities.Teacher;

import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    List<Teacher> getTeachers();

    Teacher getTeacherById(String id);

    void deleteTeacher(String id);
}
