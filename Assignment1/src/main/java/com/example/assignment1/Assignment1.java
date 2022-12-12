package com.example.assignment1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Assignment1 {

    @GetMapping("/name")
    public String name()
    {
        return "my name is Abdulmalik";
    }
    @GetMapping("/age")
    public String age()
    {
        return "my age is 24";
    }
    @GetMapping("/check/status")
    public String status()
    {
        return "Everything is OK!";
    }
    @GetMapping("/health")
    public String health()
    {
        return "Server health is up and running";
    }

}
