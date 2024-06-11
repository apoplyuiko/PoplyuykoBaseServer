package com.example.Poplyuiko_base_server.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomSuccessResponse <T> extends BaseSuccessResponse{
    private T data;
}
