package com.example.cachestoredemo.apis.MarkApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.requests.MarkRequest.PointSettingRequest;
import com.example.cachestoredemo.responses.PointRespond;
import com.example.cachestoredemo.utils.Const;
import com.example.cachestoredemo.utils.Util;
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
