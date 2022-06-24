package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.UpdateTeacherRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
import com.example.cachestoredemo.Until.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class TeacherUpdateApi extends BaseApi<UpdateTeacherRequest,TeacherRespond> {

    @Override
    protected TeacherRespond execute(UpdateTeacherRequest request) {
        Teacher teacher = request.getData();
        String id = request.getId();
        Teacher oldTeacher = teacherService.getTeacherById(id);
        teacher.setId(id);
        String teacherName = teacher.getName();
        String oldTeacherName = oldTeacher.getName();
        String name = (Util.isNull(teacherName)) ? oldTeacherName : teacherName;
        teacher.setName(name);
        String teacherSubject = teacher.getSubject();
        String oldTeacherSubject = oldTeacher.getSubject();
        String subject = (Util.isNull(teacherSubject)) ? oldTeacherSubject : teacherSubject;
        teacher.setSubject(subject);
        String teacherClass = teacher.getPersonClass();
        String oldTeacherClass = oldTeacher.getPersonClass();
        String Class = (Util.isNull(teacherClass)) ? oldTeacherClass : teacherClass;
        teacher.setPersonClass(Class);
        teacherService.updateTeacher(teacher);
        return new TeacherRespond("Update Successfully",teacher);
    }

    @Override
    protected HttpStatus validateRequest(UpdateTeacherRequest request) {
        try {
            String id = request.getId();
            Teacher oldTeacher = teacherService.getTeacherById(id);
            if(Util.isNull(oldTeacher)){
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
