package com.example.design.pattern.algorithms.sort.other;

import java.util.Random;

public class SelectSortV2 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6, 8, 0};
        arr = arr(10);
        print(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            swap(arr, i, minPos);
        }

        print(arr);

        /*for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minPos]) {
                minPos = j;
            }
        }*/

        // System.out.println(minPos);

        /*int temp;
        temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;*/
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
