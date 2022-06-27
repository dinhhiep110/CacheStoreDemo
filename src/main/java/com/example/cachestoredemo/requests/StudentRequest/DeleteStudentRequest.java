package com.example.cachestoredemo.requests.StudentRequest;

import com.example.cachestoredemo.requests.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteStudentRequest extends BaseRequest<String> {
    public DeleteStudentRequest(String data) {
        super(data);
    }
}
