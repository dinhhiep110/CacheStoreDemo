package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.GetTeacherByIdRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
import com.example.cachestoredemo.Until.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TeacherGetByIdApi extends BaseApi<GetTeacherByIdRequest,TeacherRespond> {

    @Override
    protected TeacherRespond execute(GetTeacherByIdRequest request) {
        String id = request.getData();
        Teacher teacher = teacherService.getTeacherById(id);
        return new TeacherRespond("Find teacher successfully",teacher);
    }

    @Override
    protected HttpStatus validateRequest(GetTeacherByIdRequest request) {
        try{
            String id = request.getData();
            Teacher teacher = teacherService.getTeacherById(id);
            if(Util.isNull(teacher)){
                return HttpStatus.BAD_REQUEST;
            }
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return HttpStatus.NOT_ACCEPTABLE;
        }
        return HttpStatus.OK;
    }
}
