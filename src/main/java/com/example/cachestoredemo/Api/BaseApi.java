package com.example.cachestoredemo.Api;

import com.example.cachestoredemo.Dao.PointRedisImpl;
import com.example.cachestoredemo.Request.BaseRequest;
import com.example.cachestoredemo.Respond.BaseRespond;
import com.example.cachestoredemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public abstract class BaseApi {

    @Autowired
    protected StudentService studentService;

    @Autowired
    protected PointRedisImpl pointRedis;
    public ResponseEntity<BaseRespond> doExecute(BaseRequest request){
        if(!isValidatedRequest(request)){
            return null;
        }
        return execute(request);
    }

    protected abstract ResponseEntity<BaseRespond> execute(BaseRequest request);

    protected abstract boolean isValidatedRequest(BaseRequest request);
}
