package com.example.cachestoredemo.requests.TeacherRequest;

import com.example.cachestoredemo.requests.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteTeacherRequest extends BaseRequest<String> {
    public DeleteTeacherRequest(String data) {
        super(data);
    }
}
