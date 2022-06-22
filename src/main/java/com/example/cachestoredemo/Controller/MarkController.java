package com.example.cachestoredemo.Controller;

import com.example.cachestoredemo.Api.MarkApi.MarkPointApi;
import com.example.cachestoredemo.Api.MarkApi.PointSettingApi;
import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.Dao.PointRedisImpl;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.MarkApi.MarkPointRequest;
import com.example.cachestoredemo.Request.MarkApi.PointSettingRequest;
import com.example.cachestoredemo.Services.StudentService;
import com.example.cachestoredemo.Until.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController()
@RequestMapping("/api/marks")
public class MarkController {
    @Autowired
    PointSettingApi pointSettingApi;

    @Autowired
    MarkPointApi markPointApi;
    @GetMapping("/{sid}/{point}")
    public ResponseEntity<?> markPoint(@PathVariable int sid,@PathVariable String point){
        return markPointApi.doExecute(new MarkPointRequest(point,sid));
    }

    @PutMapping()
    public ResponseEntity<?> settingPoint(@Validated @RequestBody Map<String,Integer> points){
       return pointSettingApi.doExecute(new PointSettingRequest(points));
    }

}
