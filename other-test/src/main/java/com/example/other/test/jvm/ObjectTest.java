package com.example.other.test.jvm;

import org.openjdk.jol.info.ClassLayout;

public class ObjectTest {
    public static void main(String[] args) {
        Object o = new Object();
/*        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        String s = "123";
        System.out.println(ClassLayout.parseInstance(s).toPrintable());*/
    }
}
