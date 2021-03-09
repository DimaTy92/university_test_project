package com.example.demo.entity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Response<T> {
    private final T response;

    public String getResponse() {
        return response.toString();
    }

}
