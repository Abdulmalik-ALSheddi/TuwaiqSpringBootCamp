package com.example.assignment5.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    @NotNull(message = "ID can't be null")
    private int id;

    @NotEmpty(message = "NAME can't be Empty")
    @Size(min = 2,message = "NAME must be longer than 2!!")
    private String name;

    @NotEmpty(message = "NAME can't be Empty")
    @Pattern(regexp = "(Drama|Action|Comedy)",message = "GENRE must be Drama|Action|Comedy")
    private String genre;

    @Min(value = 1,message = "RATING must be between 1 and 5")
    @Max(value = 5,message = "RATING must be between 1 and 5")
    private Integer rating;

    @NotEmpty(message = "DURATION can't be empty")
    @Min(value = 60,message = "DURATION must be more than 60")
    private Integer duration;

}
