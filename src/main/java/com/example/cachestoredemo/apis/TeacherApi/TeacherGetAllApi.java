package com.example.cachestoredemo.apis.TeacherApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.entities.Teacher;
import com.example.cachestoredemo.requests.TeacherRequest.GetAllTeacherRequest;
import com.example.cachestoredemo.responses.TeacherRespond;
import com.example.cachestoredemo.utils.Util;
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
