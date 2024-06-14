package com.example.Poplyuiko_base_server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetNewsDto<T> {
    List<T> content;

    long numberOfElements;

    long ready;

    long notReady;
}
