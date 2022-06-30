package com.example.cachestoredemo.repository;

import com.example.cachestoredemo.entities.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Insert("insert into student(id,name,person_class,total_points) values(#{id},#{name},#{personClass},#{totalPoints})")
    public void save(Student student);

    @Select("select * from student where id = #{id}")
    public Student findById(String id);

    @Select("select * from student")
    public List<Student> findAll();

    @Delete("delete from student where id = #{id}")
    public void delete(String id);

    @Update("update student set name = #{name}, person_class = #{personClass}, total_points = #{totalPoints} where id = #{id}")
    public void update(Student student);
}
