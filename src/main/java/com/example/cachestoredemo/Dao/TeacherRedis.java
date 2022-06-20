package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Entity.Teacher;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherRedis extends BaseRedis{
    private static final String TEACHER_KEY = "Teacher";
    private final Gson gson = new Gson();

    public void setTeacher(Teacher teacher){
        set(TEACHER_KEY,Integer.toString(teacher.getId()),gson.toJson(teacher));
    }

    public Teacher getTeacherById(int id){
        String teacher = get(TEACHER_KEY, Integer.toString(id));
        return gson.fromJson(teacher,Teacher.class);
    }

    public List<Teacher> getTeachers(){
        Map<String, String> teachers = getAll(TEACHER_KEY);
        List<Teacher> listTeachers = new ArrayList<>();
        for (String keys : teachers.keySet()) {
            listTeachers.add(gson.fromJson(teachers.get(keys),Teacher.class));
        }
        return listTeachers;
    }

    public void deleteTeacher(int id){
        delete(TEACHER_KEY,Integer.toString(id));
    }
}
