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
        if(!isValidatedRequest(request)){
            return new ResponseEntity<>(new BaseRespond("Invalid Request"), HttpStatus.BAD_REQUEST);
        }
        T response = execute(request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    protected abstract T execute(R request);

    protected abstract boolean isValidatedRequest(R request);
}
