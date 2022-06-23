package com.example.cachestoredemo.Controller;

import com.example.cachestoredemo.Api.MarkApi.MarkPointApi;
import com.example.cachestoredemo.Api.MarkApi.PointSettingApi;
import com.example.cachestoredemo.Request.MarkRequest.MarkPointRequest;
import com.example.cachestoredemo.Request.MarkRequest.PointSettingRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
