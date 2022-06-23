package com.example.cachestoredemo.Api.MarkApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Request.MarkRequest.MarkPointRequest;
import com.example.cachestoredemo.Respond.PointRespond;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MarkPointApi extends BaseApi <MarkPointRequest,PointRespond>{
    @Override
    protected PointRespond execute(MarkPointRequest request) {
        int sid = request.getSid();
        String point = request.getData();
        Map<String,Integer> mapPoint = CacheMemory.get();
        Student student = studentService.getStudentById(sid);
        student.setTotalPoints(student.getTotalPoints() + mapPoint.get(point));
        studentService.updateStudent(student);
        return new PointRespond("Points are marked : " + point + " " + mapPoint.get(point),student.getTotalPoints());
    }

    @Override
    protected boolean isValidatedRequest(MarkPointRequest request) {
        int sid = request.getSid();
        String point =  request.getData();
        Student student = studentService.getStudentById(sid);
        try {
            return student != null && CacheMemory.isPointExisted(point);
        }
        catch (Exception exception){
            return false;
        }
    }

}
