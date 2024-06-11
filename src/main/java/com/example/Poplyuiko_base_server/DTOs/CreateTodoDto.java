package com.example.Poplyuiko_base_server.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTodoDto {
    @NotNull
    @Size(min = 3, max = 160)
    private String text;
    private boolean status;
}
