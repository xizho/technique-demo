package com.example.other.test.other;

public class MemoryCalc {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("MAX_MEMORY   = " + maxMemory + "\\" + ((double) maxMemory) / 1024 / 1024);
        System.out.println("FREE_MEMORY  = " + freeMemory + "\\" + ((double) freeMemory) / 1024 / 1024);
        System.out.println("TOTAL_MEMORY = " + totalMemory + "\\" + ((double) totalMemory) / 1024 / 1024);
    }
}
