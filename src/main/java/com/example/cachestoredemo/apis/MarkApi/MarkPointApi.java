package com.example.cachestoredemo.apis.MarkApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.entities.Student;
import com.example.cachestoredemo.requests.MarkRequest.MarkPointRequest;
import com.example.cachestoredemo.responses.PointRespond;
import com.example.cachestoredemo.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MarkPointApi extends BaseApi <MarkPointRequest,PointRespond>{
    @Override
    protected PointRespond execute(MarkPointRequest request) {
        Map<String,String> map = request.getData();
        Map<String,Integer> mapPoint = CacheMemory.get();
        List<Student> studentMarked = new ArrayList<>();
        for (String keys: map.keySet()) {
            Student student = studentService.getStudentById(keys);
            String point = map.get(keys);
            student.setTotalPoints(student.getTotalPoints() + mapPoint.get(point));
            studentMarked.add(student);
            studentService.updateStudent(student);
        }
        return new PointRespond("Marked Point Successfully",studentMarked);
    }

    @Override
    protected HttpStatus validateRequest(MarkPointRequest request) {
        try {
            Map<String,String> map = request.getData();
            if(Util.isNull(map) || map.isEmpty()){
                return HttpStatus.UNPROCESSABLE_ENTITY;
            }
            for (String keys: map.keySet()) {
                Student student = studentService.getStudentById(keys);
                if(Util.isNull(student) || !CacheMemory.isPointExisted(map.get(keys))){
                    return HttpStatus.BAD_REQUEST;
                }
            }
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return HttpStatus.NOT_ACCEPTABLE;
        }
        return HttpStatus.OK;
    }

}
