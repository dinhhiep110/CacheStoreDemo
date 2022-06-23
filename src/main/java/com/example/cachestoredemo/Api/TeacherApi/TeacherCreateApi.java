package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.CreateTeacherRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
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
    protected boolean isValidatedRequest(CreateTeacherRequest request) {
        Teacher teacher = request.getData();
        try {
            if(teacher == null || teacher.getName() == null || teacher.getName().isEmpty()
                    || teacher.getPersonClass() == null ||  teacher.getPersonClass().isEmpty()
                    || teacher.getSubject() == null || teacher.getSubject().isEmpty()){
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
