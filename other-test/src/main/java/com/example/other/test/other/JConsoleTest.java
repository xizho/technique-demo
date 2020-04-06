package com.example.other.test.other;

import java.util.ArrayList;
import java.util.List;

public class JConsoleTest {

    public static void main(String[] args) throws InterruptedException {
        fillHeap(2000);
    }


    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50L);
            System.gc();
        }
    }

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }
}
