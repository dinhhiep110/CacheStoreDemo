package com.example.cachestoredemo.Services;

import com.example.cachestoredemo.Entity.Teacher;

import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    List<Teacher> getTeachers();

    Teacher getTeacherById(int id);

    void deleteTeacher(int id);
}
