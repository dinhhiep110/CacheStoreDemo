package com.example.cachestoredemo.requests.TeacherRequest;

import com.example.cachestoredemo.requests.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTeacherByIdRequest extends BaseRequest<String> {
    public GetTeacherByIdRequest(String data) {
        super(data);
    }
}
