package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.GetAllTeacherRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
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
    protected boolean isValidatedRequest(GetAllTeacherRequest request) {
        try{
            List<Teacher> teachers = teacherService.getTeachers();
            return !teachers.isEmpty();
        }
        catch (Exception e){
            return false;
        }
    }
}
