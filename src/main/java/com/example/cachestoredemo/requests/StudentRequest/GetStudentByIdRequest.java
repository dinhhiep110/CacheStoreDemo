package com.example.cachestoredemo.requests.StudentRequest;

import com.example.cachestoredemo.requests.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetStudentByIdRequest extends BaseRequest<String> {
    public GetStudentByIdRequest(String data) {
        super(data);
    }
}
