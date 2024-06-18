package com.example.Poplyuiko_base_server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetNewsDto<T> {
    private List<T> content;

    private long numberOfElements;

    private long ready;

    private long notReady;
}
