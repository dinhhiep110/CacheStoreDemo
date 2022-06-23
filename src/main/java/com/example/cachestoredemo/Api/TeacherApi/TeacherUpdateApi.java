package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.UpdateTeacherRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
import org.springframework.stereotype.Component;

@Component
public class TeacherUpdateApi extends BaseApi<UpdateTeacherRequest,TeacherRespond> {

    @Override
    protected TeacherRespond execute(UpdateTeacherRequest request) {
        Teacher teacher = request.getData();
        int id = request.getTid();
        Teacher oldTeacher = teacherService.getTeacherById(id);
        teacher.setId(oldTeacher.getId());
        teacher.setName((teacher.getName() == null) ? oldTeacher.getName() : teacher.getName());
        teacher.setSubject((teacher.getSubject() == null) ? oldTeacher.getSubject() : teacher.getSubject());
        teacher.setPersonClass((teacher.getPersonClass() == null) ? oldTeacher.getPersonClass() : teacher.getPersonClass());
        teacherService.updateTeacher(teacher);
        return new TeacherRespond("Update Successfully",teacher);
    }

    @Override
    protected boolean isValidatedRequest(UpdateTeacherRequest request) {
        Teacher teacher = request.getData();
        try {
            if(teacher == null){
                return false;
            }
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }
}
