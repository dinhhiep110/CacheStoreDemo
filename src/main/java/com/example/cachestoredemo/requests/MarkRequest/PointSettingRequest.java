package com.example.cachestoredemo.requests.MarkRequest;

import com.example.cachestoredemo.requests.BaseRequest;
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
