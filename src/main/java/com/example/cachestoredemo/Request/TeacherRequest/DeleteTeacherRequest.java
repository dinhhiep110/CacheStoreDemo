package com.example.cachestoredemo.Request.TeacherRequest;

import com.example.cachestoredemo.Request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteTeacherRequest extends BaseRequest<String> {
    public DeleteTeacherRequest(String data) {
        super(data);
    }
}
