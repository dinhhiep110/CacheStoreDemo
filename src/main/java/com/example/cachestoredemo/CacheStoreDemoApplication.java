package com.example.cachestoredemo;

import com.example.cachestoredemo.dao.RedisFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheStoreDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CacheStoreDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RedisFactory.init();
        CacheMemory.initCache();
    }
}
