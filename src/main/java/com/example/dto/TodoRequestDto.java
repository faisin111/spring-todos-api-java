package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequestDto {
    @NotBlank
    @Size(min = 3,max = 50)
    public String title;
    public Boolean isComplete;
}
