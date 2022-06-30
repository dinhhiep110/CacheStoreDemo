package com.example.cachestoredemo.services;

import com.example.cachestoredemo.dao.TeacherRedisImpl;
import com.example.cachestoredemo.entities.Teacher;
import com.example.cachestoredemo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
//    @Autowired
//    TeacherRedisImpl teacherRedis;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.update(teacher);
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void deleteTeacher(String id) {
        teacherRepository.delete(id);
    }


}