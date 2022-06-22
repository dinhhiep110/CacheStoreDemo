package com.example.cachestoredemo.Api.MarkApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.BaseRequest;
import com.example.cachestoredemo.Request.MarkApi.MarkPointRequest;
import com.example.cachestoredemo.Respond.BaseRespond;
import com.example.cachestoredemo.Respond.PointRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MarkPointApi extends BaseApi {
    @Override
    protected ResponseEntity<BaseRespond> execute(BaseRequest request) {
        MarkPointRequest pointRequest = (MarkPointRequest) request;
        int sid = pointRequest.getSid();
        String point = (String) request.getData();
        Map<String,Integer> mapPoint = CacheMemory.get();
        Student student = studentService.getStudentById(sid);
        if(student == null || !CacheMemory.isPointExisted(point)){
            return new ResponseEntity<>(new PointRespond("Cannot mark points",null), HttpStatus.BAD_REQUEST);
        }
        try {
            student.setTotalPoints(student.getTotalPoints() + mapPoint.get(point));
            studentService.updateStudent(student);
            return new ResponseEntity<>(new PointRespond("Points are marked : " + point + " " + mapPoint.get(point),student), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new PointRespond("Cannot mark points",exception), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    protected boolean isValidatedRequest(BaseRequest request) {
        return true;
    }
}
