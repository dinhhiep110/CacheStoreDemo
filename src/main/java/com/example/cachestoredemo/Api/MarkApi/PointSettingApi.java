package com.example.cachestoredemo.Api.MarkApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.Request.MarkRequest.PointSettingRequest;
import com.example.cachestoredemo.Respond.PointRespond;
import com.example.cachestoredemo.Until.Const;
import com.example.cachestoredemo.Until.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PointSettingApi extends BaseApi<PointSettingRequest, PointRespond> {

    @Override
    protected PointRespond execute(PointSettingRequest request) {
        Map<String,Integer> points = request.getData();
        for (String key: points.keySet()) {
            pointRedis.setPoints(Const.POINT_KEY,key, String.valueOf(points.get(key)));
            CacheMemory.update(points);
        }
        return new PointRespond("Setting successfully",points);
    }

    @Override
    protected HttpStatus validateRequest(PointSettingRequest request) {
        try {
            Map<String,Integer> points = request.getData();
            if(Util.isNull(points)){
                return HttpStatus.BAD_REQUEST;
            }
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return HttpStatus.NOT_ACCEPTABLE;
        }
        return HttpStatus.OK;
    }
}
