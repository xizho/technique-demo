package com.example.dubbo.service.impl;

import com.example.dubbo.provider.api.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
