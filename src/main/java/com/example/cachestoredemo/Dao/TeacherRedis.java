package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Teacher;

import java.util.List;

public interface TeacherRedis {
    void setTeacher(Teacher teacher);

    Teacher getTeacherById(String id);

    List<Teacher> getTeachers();

    void deleteTeacher(String id);
}
