package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.GetTeacherByIdRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TeacherGetByIdApi extends BaseApi<GetTeacherByIdRequest,TeacherRespond> {

    @Override
    protected TeacherRespond execute(GetTeacherByIdRequest request) {
        int id = request.getData();
        Teacher teacher = teacherService.getTeacherById(id);
        return new TeacherRespond("Find teacher successfully",teacher);
    }

    @Override
    protected boolean isValidatedRequest(GetTeacherByIdRequest request) {
        int id = request.getData();
        try{
            Teacher teacher = teacherService.getTeacherById(id);
            return !Objects.isNull(teacher);
        }
        catch (Exception e){
            return false;
        }
    }
}
