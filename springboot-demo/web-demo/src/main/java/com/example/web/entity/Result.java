package com.example.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Result {
    private Integer code =200;
    private String message="SUCCESS";
    private Object data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Object data) {
        this.data = data;
    }
}
