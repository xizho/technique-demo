package com.example.design.pattern.algorithms.sort.other;

import java.util.Random;

public class ShellSortV2 {
    public static void main(String[] args) {
        int[] arr = arr(10);

        print(arr);

        sort(arr);

        print(arr);
    }

    static void sort(int[] arr) {
        int length = arr.length;
        int h = 1;
        while (h <= length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3)
            for (int i = gap; i < length; i++)
                for (int j = i; j > gap - 1; j -= gap)
                    if (arr[j] < arr[j - gap])
                        swap(arr, j, j - gap);
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
