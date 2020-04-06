package com.example.design.pattern.singleton.singletons.serializable;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {


    private final static SerializableSingleton INSTANCE = new SerializableSingleton();

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 避免反序列化破坏
     * TODO 研究源码
     *
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }

}

