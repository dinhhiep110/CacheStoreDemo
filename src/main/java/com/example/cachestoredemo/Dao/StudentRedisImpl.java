package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Until.GsonUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRedisImpl extends AbstractRepository<Student> implements StudentRedis{
    private static final String STUDENT_KEY = "Student";

    @Override
    protected Student convertToEntity(String string) {
        return (Student) GsonUtil.convertToObject(string);
    }

    @Override
    protected String convertToDatabaseObject(Student entity) {
        return GsonUtil.covertFromObject(entity);
    }

    @Override
    public void setStudent(Student student) {
        insert(student,STUDENT_KEY,student.getId());
    }

    @Override
    public Student getStudentById(String id) {
        return getEntityById(id,STUDENT_KEY);
    }

    @Override
    public List<Student> getStudents() {
        return getAllEntity(STUDENT_KEY);
    }

    @Override
    public void deleteStudent(String id) {
        deleteEntity(STUDENT_KEY,id);
    }
}
