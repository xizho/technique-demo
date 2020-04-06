package com.example.design.pattern.algorithms.sort.other;

import java.util.Random;

public class InsertSortV2 {
    public static void main(String[] args) {
        int[] arr = arr(10);

        print(arr);

        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0; j--)
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);

        print(arr);
    }

    static int[] arr(int num) {
        int[] arr = new int[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            arr[i] = random.nextInt(100);
        }

        return arr;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
