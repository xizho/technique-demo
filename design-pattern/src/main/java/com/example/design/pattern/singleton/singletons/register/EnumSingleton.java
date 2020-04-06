package com.example.design.pattern.singleton.singletons.register;

/**
 * @author zhong
 */

public enum EnumSingleton {

    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
