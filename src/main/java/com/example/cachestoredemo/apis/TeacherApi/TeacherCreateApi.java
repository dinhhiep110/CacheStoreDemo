package com.example.cachestoredemo.apis.TeacherApi;

import com.example.cachestoredemo.apis.BaseApi;
import com.example.cachestoredemo.entities.Teacher;
import com.example.cachestoredemo.requests.TeacherRequest.CreateTeacherRequest;
import com.example.cachestoredemo.responses.TeacherRespond;
import com.example.cachestoredemo.utils.Util;
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
