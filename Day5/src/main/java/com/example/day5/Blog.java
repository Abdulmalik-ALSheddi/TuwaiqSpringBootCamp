package com.example.day5;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Blog {
    @NotNull(message = "ID can't be null")
    private Integer id;

    @NotEmpty(message = "TITLE can't be empty")
    private String title;

    @NotEmpty(message = "BODY can't be empty")
    private String body;

}
