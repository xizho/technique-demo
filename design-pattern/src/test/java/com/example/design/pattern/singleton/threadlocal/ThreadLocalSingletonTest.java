package com.example.design.pattern.singleton.threadlocal;

import java.util.Optional;
import java.util.stream.Stream;

public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        System.out.println("********************************");

        Stream.of("T1", "T2", "T3", "T4", "T5").forEach(name -> new Thread(() -> {
            Optional.of(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance()).ifPresent(System.out::println);
            Optional.of(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance()).ifPresent(System.out::println);
            Optional.of(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance()).ifPresent(System.out::println);
            Optional.of(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance()).ifPresent(System.out::println);
            System.out.println("********************************");
        }, name).start());
    }
}