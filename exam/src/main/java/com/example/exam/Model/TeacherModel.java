package com.example.exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherModel {
    @NotNull(message = "can not be empty")
    private Integer TeacherID;
    @NotEmpty(message = "can not be empty")
    private String name;
    @NotNull(message = "can not be empty")
    private Integer salary;
}
