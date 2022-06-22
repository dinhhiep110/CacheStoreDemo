package com.example.cachestoredemo.Request.StudentRequest;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteStudentRequest extends BaseRequest<Integer> {
    public DeleteStudentRequest(Integer data) {
        super(data);
    }
}
