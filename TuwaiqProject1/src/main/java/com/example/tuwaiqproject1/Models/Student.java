package com.example.tuwaiqproject1.Models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "Id can't be null")
    private Integer id;

    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Age can't be null")
    private Integer age;

    @Pattern(regexp = "(CS|MATH|Engineer)" , message = "Major must be CS|MATH|Engineer")
    @NotEmpty(message = "Major can't be empty")
    private String major;
}
