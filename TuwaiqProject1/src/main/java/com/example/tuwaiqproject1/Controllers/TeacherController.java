package com.example.tuwaiqproject1.Controllers;

import com.example.tuwaiqproject1.Models.Teacher;
import com.example.tuwaiqproject1.Service.Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final Service teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers()
    {
        ArrayList<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(201).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body("Teacher Added!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id , @RequestBody @Valid Teacher teacher, Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(teacherService.updateTeacher(id,teacher))
            return ResponseEntity.status(201).body("Teacher updated!!");
        return ResponseEntity.status(400).body("Teacher not found!!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id)
    {
        if(teacherService.deleteTeacher(id))
            return ResponseEntity.status(201).body("Teacher Deleted!!");
        return ResponseEntity.status(400).body("Teacher NOT FOUND!!");
    }

    @GetMapping("/get/by/name")
    public ResponseEntity getTeacherByName(@RequestBody String name)
    {
        Teacher teacher = teacherService.getTeacherByName(name);
        if( teacher != null)
            return ResponseEntity.status(201).body(teacher);
        return ResponseEntity.status(400).body("Teacher not found");
    }

    @GetMapping("/get/by/salary")
    public ResponseEntity getTeachersBySalary(@RequestBody Integer salary)
    {
        ArrayList<Teacher> salaryTeachers = teacherService.getTeachersBySalary(salary);
        if(!salaryTeachers.isEmpty())
            return ResponseEntity.status(201).body(salaryTeachers);
        return ResponseEntity.status(400).body("No teachers have "+salary+" or more");
    }
}
