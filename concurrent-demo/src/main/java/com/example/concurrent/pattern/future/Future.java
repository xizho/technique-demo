package com.example.concurrent.pattern.future;

public interface Future<T> {

    T get() throws InterruptedException;
}
