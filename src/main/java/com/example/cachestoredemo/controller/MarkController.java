package com.example.cachestoredemo.controller;

import com.example.cachestoredemo.apis.MarkApi.MarkPointApi;
import com.example.cachestoredemo.apis.MarkApi.PointSettingApi;
import com.example.cachestoredemo.requests.MarkRequest.MarkPointRequest;
import com.example.cachestoredemo.requests.MarkRequest.PointSettingRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class MarkController {
    @Autowired
    PointSettingApi pointSettingApi;

    @Autowired
    MarkPointApi markPointApi;
    @PutMapping ("/points/mark")
    public ResponseEntity<?> markPoint(@Validated @NonNull @RequestBody Map<String,String> pointMarked){
        return markPointApi.doExecute(new MarkPointRequest(pointMarked));
    }

    @PutMapping("/points/setting")
    public ResponseEntity<?> settingPoint(@Validated @NonNull @RequestBody Map<String,Integer> points){
       return pointSettingApi.doExecute(new PointSettingRequest(points));
    }

}
