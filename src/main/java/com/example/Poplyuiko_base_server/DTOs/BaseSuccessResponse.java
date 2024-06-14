package com.example.Poplyuiko_base_server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseSuccessResponse {
    private int statusCode;

    private boolean success = true;
}
