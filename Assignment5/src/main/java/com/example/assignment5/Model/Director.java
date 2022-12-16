package com.example.assignment5.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Director {

    @NotEmpty(message = "ID can't be null")
    @Size(min = 3,message = "ID must be longer than 3")
    private String id;

    @NotEmpty(message = "NAME can't be null")
    @Size(min = 2,message = "NAME length must be more than 2")
    private String name;

}
