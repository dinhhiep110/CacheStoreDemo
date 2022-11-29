package com.example.cachestoredemo.repository;

import com.example.cachestoredemo.entities.Point;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PointRepository {
    @Update("update point set value = #{value} where name = #{name}")
    void update(Point point);

    @Insert("insert into point(name,value) values(#{name},#{value})")
    void save(Point point);

    @Select("select * from point where name = #{name}")
    Point findByName(String name);
}
