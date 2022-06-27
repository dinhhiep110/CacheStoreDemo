package com.example.cachestoredemo.services;

import com.example.cachestoredemo.dao.TeacherRedisImpl;
import com.example.cachestoredemo.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRedisImpl teacherRedis;


    @Override
    public void addTeacher(Teacher teacher) {
        teacherRedis.setTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRedis.setTeacher(teacher);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRedis.getTeachers();
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherRedis.getTeacherById(id);
    }

    @Override
    public void deleteTeacher(String id) {
        teacherRedis.deleteTeacher(id);
    }


}