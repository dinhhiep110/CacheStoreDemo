package com.example.cachestoredemo;

import com.example.cachestoredemo.Dao.BaseRedis;
import com.example.cachestoredemo.Dao.PointRedis;
import com.example.cachestoredemo.Dao.RedisFactory;
import com.example.cachestoredemo.Until.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class CacheStoreDemoApplication implements CommandLineRunner {

    @Autowired
    PointRedis pointRedis;

    public static void main(String[] args) {
        SpringApplication.run(CacheStoreDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RedisFactory.init();
        Map<String, String> points = pointRedis.getPoints(Const.POINT_KEY);
        CacheMemory.add(points);
    }
}
