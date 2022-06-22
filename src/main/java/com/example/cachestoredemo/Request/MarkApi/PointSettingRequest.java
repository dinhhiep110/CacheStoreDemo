package com.example.cachestoredemo.Request.MarkApi;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PointSettingRequest extends BaseRequest<Map<String,Integer>> {
    public PointSettingRequest(Map<String, Integer> data) {
        super(data);
    }
}
