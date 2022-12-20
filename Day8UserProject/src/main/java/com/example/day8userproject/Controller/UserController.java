package com.example.day8userproject.Controller;

import com.example.day8userproject.Dto.APIResponse;
import com.example.day8userproject.Model.User;
import com.example.day8userproject.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers()
    {
        return ResponseEntity.status(201).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user)
    {
        userService.addUser(user);
        return ResponseEntity.status(201).body(new APIResponse("User Added !!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user)
    {
        userService.updateUser(id,user);
        return ResponseEntity.status(201).body(new APIResponse("User Updated !!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
        return ResponseEntity.status(201).body(new APIResponse("User deleted !!"));
    }

    /* Check if username and password match*/
    @GetMapping("/check/{password}")
    public ResponseEntity check(@RequestBody String username , @PathVariable String password)
    {
        return ResponseEntity.status(201).body(userService.check(username,password));
    }

    /*Get user by email*/
    @GetMapping("/get/by/email")
    public ResponseEntity getUserByEmail(@RequestBody String email)
    {
        return ResponseEntity.status(201).body(userService.getUserByEmail(email));
    }

    /*Get All users with specific role*/
    @GetMapping("/get/by/role")
    public ResponseEntity getUsersByRole(@RequestBody String role)
    {
        return ResponseEntity.status(201).body(userService.getUsersByRole(role));
    }

    /*Get All users with specific age or above*/
    @GetMapping("/get/by/age")
    public ResponseEntity getUsersByAge(@RequestBody Integer age)
    {
        return ResponseEntity.status(201).body(userService.getUsersByAge(age));
    }
}
