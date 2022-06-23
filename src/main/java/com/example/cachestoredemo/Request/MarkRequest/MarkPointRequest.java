package com.example.cachestoredemo.Request.MarkRequest;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkPointRequest extends BaseRequest<String> {
    private int sid;

    public MarkPointRequest(String data, int sid) {
        super(data);
        this.sid = sid;
    }
}
