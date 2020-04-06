package com.example.design.pattern.singleton.threadlocal;

public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> THREADLOCAL_INSTANCE = ThreadLocal.withInitial(() -> new ThreadLocalSingleton());

    public static ThreadLocalSingleton getInstance() {
        return THREADLOCAL_INSTANCE.get();
    }
}
