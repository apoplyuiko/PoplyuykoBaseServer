package com.example.Poplyuiko_base_server.DTOs;

import com.example.Poplyuiko_base_server.handling.ValidationConstants;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangeStatusToDoDto {
    @NotNull (message = ValidationConstants.TODO_STATUS_NOT_NULL)
    private Boolean status;
}
