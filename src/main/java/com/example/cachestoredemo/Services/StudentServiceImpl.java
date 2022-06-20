package com.example.cachestoredemo.Services;

import com.example.cachestoredemo.Dao.StudentRedis;
import com.example.cachestoredemo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRedis studentRedis;

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
    public Student getStudentById(int id) {
        return studentRedis.getStudentById(id);
    }

    @Override
    public void deleteStudent(int id) {
        studentRedis.deleteStudent(id);
    }
}
