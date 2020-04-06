package com.example.design.pattern.singleton.singletons.hungry;

public class HungrySingletonTest {

    public static void main(String[] args) {
        System.out.println(HungrySingleton.getInstance() == HungrySingleton.getInstance());
    }

}
