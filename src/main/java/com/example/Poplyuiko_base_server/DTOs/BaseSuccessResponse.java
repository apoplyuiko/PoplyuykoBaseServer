package com.example.Poplyuiko_base_server.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class BaseSuccessResponse {
    private int statusCode;
    private boolean success;
    private String message;
    private Map<String, String> errors;
}
