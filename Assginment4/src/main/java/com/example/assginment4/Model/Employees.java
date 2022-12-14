package com.example.assginment4.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data@AllArgsConstructor
public class Employees {
    @NotEmpty(message = "ID can't be null")
    @Size(min = 2 , message = "ID Length must be more than two!")
    String id;
    @NotEmpty(message = "NAME can't be null")
    @Size(min = 4,message = "NAME size must be more than four!")
    String name;
    @NotNull(message = "AGE can't be null")
    @Min(value = 26,message = "AGE must be more than 25")
    int age;
    @AssertFalse(message = "ONLEAVE must be false")
    boolean onLeave;
    @NotNull(message = "EMPLYMENTYEAR cant't be null")
    @Min(value = 1997,message = "EMPLYMENTYEAR must be more than 1997")
    @Max(value = 2022,message = "EMPLYMENTYEAR must be less than 2022")
    int empYear ;
    @NotNull(message = "ANNUAL LEAVE can't be null")
    @Positive(message = "ANNUAL LEAVE must be positive")
    int annualLeave;

}
