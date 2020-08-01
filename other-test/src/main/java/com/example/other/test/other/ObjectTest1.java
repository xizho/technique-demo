package com.example.other.test.other;

public class ObjectTest1 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }
}
