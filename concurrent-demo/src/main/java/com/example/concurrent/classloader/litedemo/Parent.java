package com.example.concurrent.classloader.litedemo;

/**
 * 类职责：<br/>
 *
 * <p>Title: Parent.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年09月21日 下午上午 11:39
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class Parent {

    static {
        System.out.println("The parent is init..");
    }

    public static int y = 100;

}
