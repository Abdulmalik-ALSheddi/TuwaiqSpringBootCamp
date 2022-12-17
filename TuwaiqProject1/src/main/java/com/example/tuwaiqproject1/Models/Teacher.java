package com.example.tuwaiqproject1.Models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotNull(message = "Id can't be null")
    private Integer id;

    @NotEmpty(message = "Nmae can't be empty")
    private String name;

    @NotNull(message = "Salary can't be null")
    private Integer salary;
}
