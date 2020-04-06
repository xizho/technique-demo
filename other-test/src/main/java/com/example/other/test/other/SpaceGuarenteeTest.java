package com.example.other.test.other;

public class SpaceGuarenteeTest {
    public static void main(String[] args) {
        byte[] bytes1 = new byte[1024 * 1024 * 2];
        byte[] bytes2 = new byte[1024 * 1024 * 2];
        byte[] bytes3 = new byte[1024 * 1024 * 2];
        byte[] bytes4 = new byte[1024 * 1024 * 4];

        System.gc();
    }
}
