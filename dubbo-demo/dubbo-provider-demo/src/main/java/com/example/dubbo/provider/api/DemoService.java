package com.example.dubbo.provider.api;

public interface DemoService {

    /**
     * 提供者方法
     *
     * @param name  入参
     * @return String
     */
    String hello(String name);

}
