package com.example.springboot.base.test;

import org.junit.*;

import java.time.Instant;

/**
 * 类职责：<br/>
 *
 * <p>Title: TestJUnit.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月07日 下午下午 2:14
 * <p></p>
 * <p> </p>
 */
public class TestJUnit2 {

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("TestJUnit2单元测试开始之前执行初始化...");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("TestJUnit2单元测试结束之后执行...");
    }

    @Before
    public void beforeTest() {
        System.out.println("TestJUnit2单元测试方法开始之前执行...");
    }

    @After
    public void afterTest() {
        System.out.println("TestJUnit2单元测试方法结束之后执行...");
    }

    @Test
    public void testJUnit() {
        System.out.println("TestJUnit2" + Instant.now());
    }

}
