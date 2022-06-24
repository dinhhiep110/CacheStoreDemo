package com.example.cachestoredemo.Request.TeacherRequest;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTeacherByIdRequest extends BaseRequest<String> {
    public GetTeacherByIdRequest(String data) {
        super(data);
    }
}
