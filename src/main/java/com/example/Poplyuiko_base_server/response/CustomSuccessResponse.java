package com.example.Poplyuiko_base_server.response;

import com.example.Poplyuiko_base_server.DTOs.GetNewsDto;
import com.example.Poplyuiko_base_server.models.ToDo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomSuccessResponse<T> extends BaseSuccessResponse {
    private T data;

    public CustomSuccessResponse(T data) {
        this.data = data;
    }

    public CustomSuccessResponse(int statusCode, T data) {
        super.setStatusCode(statusCode);
        this.data = data;
    }
}
