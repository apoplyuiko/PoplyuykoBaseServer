package com.example.Poplyuiko_base_server.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomSuccessResponse<T> extends BaseSuccessResponse {
    private Integer code;

    private Boolean success = true;

    private T data;

    public <S extends T> CustomSuccessResponse(S todo) {
        data = todo;
    }
}
