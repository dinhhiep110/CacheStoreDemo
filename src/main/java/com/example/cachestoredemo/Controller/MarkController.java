package com.example.cachestoredemo.Controller;

import com.example.cachestoredemo.Api.MarkApi.MarkPointApi;
import com.example.cachestoredemo.Api.MarkApi.PointSettingApi;
import com.example.cachestoredemo.Request.MarkRequest.MarkPointRequest;
import com.example.cachestoredemo.Request.MarkRequest.PointSettingRequest;
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
