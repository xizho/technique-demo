package com.example.design.pattern.singleton;

import com.example.design.pattern.singleton.demo.SingletonDemo1;
import com.example.design.pattern.singleton.demo.SingletonDemo2;
import com.example.design.pattern.singleton.demo.SingletonDemo4;
import org.junit.Test;

public class SingletonDemo1Test {

    @Test
    public void testSingleton1() {
        SingletonDemo1.createAString();
    }

    @Test
    public void testSingleton2() {
        SingletonDemo2.createAString();
    }

    @Test
    public void testSingleton4() {
        SingletonDemo4.getInstance();
    }

}