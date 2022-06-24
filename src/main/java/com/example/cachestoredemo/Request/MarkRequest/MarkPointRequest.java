package com.example.cachestoredemo.Request.MarkRequest;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class MarkPointRequest extends BaseRequest<Map<String,String>> {
    public MarkPointRequest(Map<String,String> data) {
        super(data);
    }
}
