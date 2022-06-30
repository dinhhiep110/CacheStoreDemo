package com.example.cachestoredemo.services;

import com.example.cachestoredemo.dao.StudentRedisImpl;
import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
//    @Autowired
//    StudentRedisImpl studentRedis;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.delete(id);
    }


}
