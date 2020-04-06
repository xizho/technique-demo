package com.example.other.test.other;

public class JMKTest {

    public static void main(String[] args) {
        while (true) {
            Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
            t.run();

            byte[] b = new byte[1024 * 1024 * 10];

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
