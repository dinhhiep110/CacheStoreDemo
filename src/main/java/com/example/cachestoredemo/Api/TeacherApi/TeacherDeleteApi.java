package com.example.cachestoredemo.Api.TeacherApi;

import com.example.cachestoredemo.Api.BaseApi;
import com.example.cachestoredemo.Entity.Teacher;
import com.example.cachestoredemo.Request.TeacherRequest.DeleteTeacherRequest;
import com.example.cachestoredemo.Respond.TeacherRespond;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TeacherDeleteApi extends BaseApi<DeleteTeacherRequest,TeacherRespond> {

    @Override
    protected TeacherRespond execute(DeleteTeacherRequest request) {
        int id = request.getData();
        Teacher teacher = teacherService.getTeacherById(id);
        teacherService.deleteTeacher(id);
        return new TeacherRespond("Delete Successfully",teacher);
    }

    @Override
    protected boolean isValidatedRequest(DeleteTeacherRequest request) {
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
