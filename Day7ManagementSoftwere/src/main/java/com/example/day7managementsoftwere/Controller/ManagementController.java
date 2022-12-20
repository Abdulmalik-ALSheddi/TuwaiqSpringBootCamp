package com.example.day7managementsoftwere.Controller;

import com.example.day7managementsoftwere.Dto.APIResponse;
import com.example.day7managementsoftwere.Model.User;
import com.example.day7managementsoftwere.Service.ManagementService;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
@RequiredArgsConstructor
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping("/get")
    public ResponseEntity getUser()
    {
        return ResponseEntity.status(201).body(managementService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user, Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        managementService.addUser(user);
        return ResponseEntity.status(201).body(new APIResponse("User Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id , @RequestBody @Valid User user, Errors er)
    {
        if(er.hasErrors())
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
        if(managementService.updateUser(id,user))
            return ResponseEntity.status(201).body(new APIResponse("User updated!!"));
        return ResponseEntity.status(400).body(new APIResponse("User NOT FOUND!!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        if(managementService.deleteUser(id))
            return ResponseEntity.status(201).body(new APIResponse("User deleted!!"));
        return ResponseEntity.status(400).body(new APIResponse("User NOT FOUND!!"));
    }
}
