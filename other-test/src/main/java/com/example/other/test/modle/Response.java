package com.example.other.test.modle;

import lombok.Data;

@Data
public class Response<T> {
    private String code;
    private String message;
    private T data;
}
