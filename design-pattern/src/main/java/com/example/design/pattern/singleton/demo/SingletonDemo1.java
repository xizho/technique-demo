package com.example.design.pattern.singleton.demo;

/**
 * 类职责：<br/>
 *
 * <p>Title: SingletonDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月06日 下午下午 5:23
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class SingletonDemo1 {

    private static SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1() {
        System.out.println("create a singleton object");
    }

    public static SingletonDemo1 getInstance() {
        return instance;
    }

    public static void createAString() {
        System.out.println("create a string ");
    }

}
