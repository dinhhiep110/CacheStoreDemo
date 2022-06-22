package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeacherRedis {
    void setTeacher(Teacher teacher);

    Teacher getTeacherById(int id);

    List<Teacher> getTeachers();

    void deleteTeacher(int id);
}
