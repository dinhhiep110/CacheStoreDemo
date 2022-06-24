package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.CreateTeacherRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
import com.example.cachestoredemo.Until.Util;
import com.google.gson.annotations.Until;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TeacherCreateApi extends BaseApi<CreateTeacherRequest, TeacherRespond> {

    @Override
    protected TeacherRespond execute(CreateTeacherRequest request) {
        Teacher teacher = request.getData();
        Teacher newTeacher = new Teacher(teacher.getName(),teacher.getPersonClass(),teacher.getSubject());
        teacherService.addTeacher(newTeacher);
        return new TeacherRespond("Add Successfully",newTeacher);
    }

    @Override
    protected HttpStatus validateRequest(CreateTeacherRequest request) {
        try {
            Teacher teacher = request.getData();
            if (Util.isNull(teacher) || Util.isNull(teacher.getName())
            || Util.isNull(teacher.getPersonClass()) || Util.isNull(teacher.getSubject())) {
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
