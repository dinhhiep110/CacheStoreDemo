package com.example.cachestoredemo.dao;

import com.example.cachestoredemo.entities.Teacher;
import com.example.cachestoredemo.utils.GsonUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRedisImpl extends AbstractRepository<Teacher> implements TeacherRedis{
    private static final String TEACHER_KEY = "Teacher";

    @Override
    protected Teacher convertToEntity(String string) {
        return GsonUtil.convertToObject(string,Teacher.class);
    }

    @Override
    protected String convertToDatabaseObject(Teacher entity) {
        return GsonUtil.covertFromObject(entity);
    }

    @Override
    public void setTeacher(Teacher teacher) {
        insert(teacher,TEACHER_KEY,teacher.getId());
    }

    @Override
    public Teacher getTeacherById(String id) {
        return getEntityById(id,TEACHER_KEY);
    }

    @Override
    public List<Teacher> getTeachers() {
        return getAllEntity(TEACHER_KEY);
    }

    @Override
    public void deleteTeacher(String id) {
        deleteEntity(TEACHER_KEY,id);
    }
}
