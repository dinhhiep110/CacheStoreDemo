package com.example.cachestoredemo.Dao;

import com.example.cachestoredemo.Entity.Student;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRedis extends BaseRedis{
    private static final String STUDENT_KEY = "Student";
    private final Gson gson = new Gson();

    public void setStudent(Student student){
        set(STUDENT_KEY,Integer.toString(student.getId()),gson.toJson(student));
    }

    public Student getStudentById(int id){
        String student = get(STUDENT_KEY, Integer.toString(id));
        return gson.fromJson(student,Student.class);
    }

    public List<Student> getStudents(){
        Map<String, String> students = getAll(STUDENT_KEY);
        List<Student> listStudent = new ArrayList<>();
        for (String keys : students.keySet()) {
            listStudent.add(gson.fromJson(students.get(keys),Student.class));
        }
        return listStudent;
    }

    public void deleteStudent(int id){
        delete(STUDENT_KEY,Integer.toString(id));
    }

}
