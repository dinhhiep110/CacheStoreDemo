package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Teacher;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherRedisImpl extends BaseRedis implements TeacherRedis,GsonConvert<Teacher>{
    private static final String TEACHER_KEY = "Teacher";
    private final Gson gson = new Gson();
    public void setTeacher(Teacher teacher){
        set(TEACHER_KEY,Integer.toString(teacher.getId()),convertToString(teacher));
    }

    public Teacher getTeacherById(int id){
        String teacher = get(TEACHER_KEY, Integer.toString(id));
        return convertToObject(teacher);
    }

    public List<Teacher> getTeachers(){
        Map<String, String> teachers = getAll(TEACHER_KEY);
        List<Teacher> listTeachers = new ArrayList<>();
        for (String keys : teachers.keySet()) {
            listTeachers.add(convertToObject(teachers.get(keys)));
        }
        return listTeachers;
    }

    public void deleteTeacher(int id){
        delete(TEACHER_KEY,Integer.toString(id));
    }

    @Override
    public String convertToString(Teacher teacher) {
        return gson.toJson(teacher);
    }

    @Override
    public Teacher convertToObject(String string) {
        return gson.fromJson(string,Teacher.class);
    }
}
