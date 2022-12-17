package com.example.tuwaiqproject1.Controllers;

import com.example.tuwaiqproject1.Models.Student;
import com.example.tuwaiqproject1.Service.Service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final Service studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents()
    {
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.status(201).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student , Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        studentService.addStudent(student);
        return ResponseEntity.status(201).body("Student Added!!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id , @RequestBody @Valid Student student, Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(studentService.updateStudent(id, student))
            return ResponseEntity.status(201).body("STUDENT Updated!!");
        return ResponseEntity.status(400).body("STUDENT NOT FOUND!!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id)
    {
        if(studentService.deleteStudent(id))
            return ResponseEntity.status(201).body("STUDENT DELETED!!");
        return ResponseEntity.status(400).body("STUDENT NOT FOUND!!");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getStudentByID(@PathVariable int id)
    {
        Student student= studentService.getStudentById(id);
        if(student != null)
            return ResponseEntity.status(201).body(student);
        return ResponseEntity.status(400).body("STUDENT NOT FOUND!!");
    }

    @GetMapping("/get/by/name")
    public ResponseEntity getStudentByName(@RequestBody String name)
    {
        Student student = studentService.getStudentsByName(name);
        if(student != null)
            return ResponseEntity.status(201).body(student);
        return ResponseEntity.status(400).body("STUDENT NOT FOUND!!");
    }

    @GetMapping("/get/by/major")
    public ResponseEntity getMajorStudents(@RequestBody String major)
    {
        ArrayList<Student> majorStudents = studentService.getMajorStudents(major);
        if(!majorStudents.isEmpty())
            return ResponseEntity.status(201).body(majorStudents);
        return ResponseEntity.status(400).body("No Students in "+major);
    }

    @GetMapping("/get/by/age")
    public ResponseEntity getAgeStudents(@RequestBody Integer age)
    {
        ArrayList<Student> ageStudents = studentService.getAgeStudents(age);
        if(!ageStudents.isEmpty())
            return ResponseEntity.status(201).body(ageStudents);
        return ResponseEntity.status(400).body("No Students are "+age+" or older");
    }
}
