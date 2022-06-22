package com.example.cachestoredemo.Request.MarkApi;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkPointRequest extends BaseRequest {
    private int sid;

    public MarkPointRequest(Object data, int sid) {
        super(data);
        this.sid = sid;
    }
}
