package com.example.Poplyuiko_base_server.DTOs;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomSuccessResponse <T> extends BaseSuccessResponse{
    private T data;
    private List<T> dataList;
}
