package com.example.cachestoredemo.Controller;

import com.example.cachestoredemo.CacheMemory;
import com.example.cachestoredemo.Dao.PointRedis;
import com.example.cachestoredemo.Entity.Student;
import com.example.cachestoredemo.Services.StudentService;
import com.example.cachestoredemo.Until.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController()
@RequestMapping("/api/marks")
public class MarkController {
    @Autowired
    StudentService studentService;

    @Autowired
    PointRedis pointRedis;

    @GetMapping("/{sid}/{point}")
    public ResponseEntity<?> markPoint(@PathVariable int sid,@PathVariable String point){
        Map<String,Integer> mapPoint = CacheMemory.get();
        Student student = studentService.getStudentById(sid);
        if(student == null || !CacheMemory.isPointExisted(point)){
            return new ResponseEntity<>("Cannot mark points", HttpStatus.BAD_REQUEST);
        }
        try {
            student.setTotalPoints(student.getTotalPoints() + mapPoint.get(point));
            studentService.updateStudent(student);
            return new ResponseEntity<>("Points are marked", HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>("Cannot mark points", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> settingPoint(@RequestBody Map<String,Integer> points){
       try {
           for (String key: points.keySet()) {
               pointRedis.setPoints(Const.POINT_KEY,key, String.valueOf(points.get(key)));
               CacheMemory.update(points);
           }
           return new ResponseEntity<>("Setting successfully", HttpStatus.OK);
       }
       catch (Exception ex){
           return new ResponseEntity<>("Cannot Set Point", HttpStatus.BAD_REQUEST);
       }
    }

}
