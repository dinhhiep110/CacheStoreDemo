package com.example.cachestoredemo.Services;

import com.example.cachestoredemo.Dao.StudentRedisImpl;
import com.example.cachestoredemo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRedisImpl studentRedis;

    @Override
    public void addStudent(Student student) {
        studentRedis.setStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRedis.setStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRedis.getStudents();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRedis.getStudentById(id);
    }

    @Override
    public void deleteStudent(String id) {
        studentRedis.deleteStudent(id);
    }


}
