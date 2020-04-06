package com.example.other.test.jvm;

public class JVMTest {
    private static int unit = 1024 * 1024;

    public static void main(String[] args) {
//        long max = Runtime.getRuntime().maxMemory();
        System.out.println(Runtime.getRuntime().maxMemory() / unit);
        byte[] temp = new byte[unit];
        byte[] a, b, c, d, e;
//        a = new byte[unit * 1];
//        b = new byte[unit * 2];
//        c = new byte[unit * 2];
//        d = new byte[unit * 4];
//        e = new byte[unit * 5];
    }
}
