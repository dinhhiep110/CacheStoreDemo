package com.example.cachestoredemo.dao;

import com.example.cachestoredemo.entities.Teacher;

import java.util.List;

public interface TeacherRedis {
    void setTeacher(Teacher teacher);

    Teacher getTeacherById(String id);

    List<Teacher> getTeachers();

    void deleteTeacher(String id);
}
