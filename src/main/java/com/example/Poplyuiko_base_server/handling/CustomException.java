package com.example.Poplyuiko_base_server.handling;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class CustomException extends RuntimeException {
    private final ErrorCodes errorCodes;
}
