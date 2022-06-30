package com.example.cachestoredemo.apis;

import com.example.cachestoredemo.dao.PointRedisImpl;
import com.example.cachestoredemo.repository.PointRepository;
import com.example.cachestoredemo.requests.BaseRequest;
import com.example.cachestoredemo.responses.BaseRespond;
import com.example.cachestoredemo.services.StudentService;
import com.example.cachestoredemo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseApi <R extends BaseRequest, T extends BaseRespond>{

    @Autowired
    protected StudentService studentService;

    @Autowired
    protected TeacherService teacherService;

    @Autowired
    protected PointRepository pointRepository;
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
