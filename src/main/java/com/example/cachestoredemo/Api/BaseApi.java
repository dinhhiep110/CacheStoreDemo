package com.example.cachestoredemo.Api;

import com.example.cachestoredemo.Dao.PointRedisImpl;
import com.example.cachestoredemo.Request.BaseRequest;
import com.example.cachestoredemo.Respond.BaseRespond;
import com.example.cachestoredemo.Services.StudentService;
import com.example.cachestoredemo.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseApi <R extends BaseRequest, T extends BaseRespond>{

    @Autowired
    protected StudentService studentService;

    @Autowired
    protected TeacherService teacherService;

    @Autowired
    protected PointRedisImpl pointRedis;
    public ResponseEntity<?> doExecute(R request){
        HttpStatus statusCode = validateRequest(request);
        if(statusCode != HttpStatus.OK){
            return new ResponseEntity<>("Invalid Request", statusCode);
        }
        T response = execute(request);
        return new ResponseEntity<>(response,statusCode);
    }

    protected abstract T execute(R request);

    protected abstract HttpStatus validateRequest(R request);
}
