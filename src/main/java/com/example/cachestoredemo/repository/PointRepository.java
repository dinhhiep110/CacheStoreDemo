package com.example.cachestoredemo.repository;

import com.example.cachestoredemo.entities.Point;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PointRepository {
    @Update("update point set value = #{value} where name = #{name}")
    public void update(Point point);

    @Insert("insert into point(name,value) values(#{name},#{value})")
    public void save(Point point);

    @Select("select * from point where name = #{name}")
    public Point findByName(String name);

}
