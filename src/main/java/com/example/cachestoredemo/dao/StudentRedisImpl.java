package com.example.cachestoredemo.dao;

import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.utils.GsonStudentUtil;
import com.example.cachestoredemo.utils.GsonUtil;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentRedisImpl extends AbstractRepository<Student> implements StudentRedis{
    private static final String STUDENT_KEY = "Student";

    @Override
    protected Student convertToEntity(String string) {
        return new GsonStudentUtil().convertToObject(string);
    }

    @Override
    protected String convertToDatabaseObject(Student entity) {
        return new GsonStudentUtil().covertFromObject(entity);
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
