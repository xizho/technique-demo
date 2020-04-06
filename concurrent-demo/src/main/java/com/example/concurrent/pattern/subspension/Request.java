package com.example.concurrent.pattern.subspension;

public class Request {

    private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
