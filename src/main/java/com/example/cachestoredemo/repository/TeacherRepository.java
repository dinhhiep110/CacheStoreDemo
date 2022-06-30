package com.example.cachestoredemo.repository;

import com.example.cachestoredemo.entities.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherRepository {
    @Insert("insert into teacher(id,name,person_class,subject) values(#{id},#{name},#{personClass},#{subject})")
    public void save(Teacher teacher);

    @Select("select * from teacher where id = #{id}")
    public Teacher findById(String id);

    @Select("select * from teacher")
    public List<Teacher> findAll();

    @Update("update teacher set name = #{name}, person_class = #{personClass}, subject = #{subject} where id = #{id}")
    public void update(Teacher teacher);

    @Delete("delete from teacher where id = #{id}")
    public void delete(String id);
}
