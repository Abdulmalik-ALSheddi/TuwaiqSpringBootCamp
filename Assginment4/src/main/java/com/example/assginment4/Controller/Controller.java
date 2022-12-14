package com.example.assginment4.Controller;

import com.example.assginment4.Model.APIResponse;
import com.example.assginment4.Model.Employees;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    ArrayList<Employees> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employees> getEmployees()
    {
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employees emp , Errors er)
    {
        if(er.hasErrors())
        {
            String msg = er.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        employees.add(emp);
        return ResponseEntity.status(201).body(new APIResponse("Employee Added!!"));
    }

    @PutMapping("/update/{i}")
    public ResponseEntity updateEmployee( @PathVariable int i , @RequestBody @Valid Employees emp , Errors er)
    {
        if(er.hasErrors())
        {
            String msg = er.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        employees.set(i,emp);
        return ResponseEntity.status(201).body(new APIResponse("Employee updated"));
    }

    @DeleteMapping("/delete/{i}")
    public ResponseEntity deleteEmployee(@PathVariable int i, Errors er)
    {
        if(er.hasErrors())
        {
            String msg = er.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        employees.remove(i);
        return ResponseEntity.status(201).body(new APIResponse("Employee deleted"));
    }
}
