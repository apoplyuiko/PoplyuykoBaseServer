package com.example.Poplyuiko_base_server.DTOs;

import com.example.Poplyuiko_base_server.handling.ValidationConstants;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChangeTextTodoDto {
    @Size(min = 3, max = 160, message = ValidationConstants.TODO_TEXT_SIZE_NOT_VALID)
    private String text;
}
