package com.example.cachestoredemo.requests.MarkRequest;

import com.example.cachestoredemo.requests.BaseRequest;
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
