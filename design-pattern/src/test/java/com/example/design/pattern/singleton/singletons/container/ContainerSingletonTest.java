package com.example.design.pattern.singleton.singletons.container;

import java.util.stream.Stream;

public class ContainerSingletonTest {

    public static void main(String[] args) {
        Stream.of("T1", "T2", "T3", "T4", "T5").forEach(name -> new Thread(() -> {
            Object obj = ContainerSingleton.getBean("com.example.design.pattern.singleton.singletons.container.ContainerSingletonTest");
            System.out.println(Thread.currentThread().getName() + ":" + obj);
        }, name).start());
    }

}