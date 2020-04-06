package com.example.other.test.other;

public class IntegerTest {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }


    public static void main(String[] args) {
        System.out.println(workerCountOf(8));
        System.out.println(runStateOf(8));
        System.out.println(ctlOf(6, 4));
    }
}
