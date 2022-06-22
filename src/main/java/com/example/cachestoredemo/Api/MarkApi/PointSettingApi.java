package com.example.cachestoredemo.Api.MarkApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.Request.BaseRequest;
import com.example.cachestoredemo.Respond.BaseRespond;
import com.example.cachestoredemo.Respond.PointRespond;
import com.example.cachestoredemo.Until.Const;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PointSettingApi extends BaseApi {

    @Override
    protected ResponseEntity<BaseRespond> execute(BaseRequest request) {
        Map<String,Integer> points = (Map<String,Integer>) request.getData();
        try {
            for (String key: points.keySet()) {
                pointRedis.setPoints(Const.POINT_KEY,key, String.valueOf(points.get(key)));
                CacheMemory.update(points);
            }
            return new ResponseEntity<>(new PointRespond("Setting successfully",points), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(new PointRespond("Cannot Set Point",ex), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    protected boolean isValidatedRequest(BaseRequest request) {
        Map<String,Integer> points = (Map<String,Integer>) request.getData();
        try {
            if(points == null){
                return false;
            }
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
