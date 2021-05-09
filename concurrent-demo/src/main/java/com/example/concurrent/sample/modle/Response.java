package com.example.concurrent.sample.modle;

import lombok.Data;

@Data
public class Response<T> {
    private String code;
    private String message;
    private T data;
}
