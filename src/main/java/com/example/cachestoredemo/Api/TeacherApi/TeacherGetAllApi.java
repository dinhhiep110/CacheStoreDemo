package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.GetAllTeacherRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
import com.example.cachestoredemo.Until.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TeacherGetAllApi extends BaseApi<GetAllTeacherRequest,TeacherRespond> {

    @Override
    protected TeacherRespond execute(GetAllTeacherRequest request) {
        List<Teacher> teachers = teacherService.getTeachers();
        return new TeacherRespond("List teachers",teachers);
    }

    @Override
    protected HttpStatus validateRequest(GetAllTeacherRequest request) {
        try{
            List<Teacher> teachers = teacherService.getTeachers();
            if(Util.isNull(teachers) || teachers.isEmpty()){
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
