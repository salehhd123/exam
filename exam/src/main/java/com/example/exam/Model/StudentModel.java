package com.example.exam.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel {

    @NotNull(message = "can not be empty")
    private Integer StudentID;
    @NotEmpty(message = "can not be empty")
    private String name;
    @NotNull(message = "can not be empty")
    private Integer age ;
    @NotEmpty(message = "can not be empty")
    private String major ;
}
