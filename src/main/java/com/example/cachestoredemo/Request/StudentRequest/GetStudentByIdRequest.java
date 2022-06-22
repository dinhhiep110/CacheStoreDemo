package com.example.cachestoredemo.Request.StudentRequest;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetStudentByIdRequest extends BaseRequest<Integer> {
    public GetStudentByIdRequest(Integer data) {
        super(data);
    }
}
