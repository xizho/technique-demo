package com.example.design.pattern.algorithms.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 6, 2, 9, 3, 3, 5};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int curVal = arr[i];
            int j = i - 1;
            for (j = i - 1; j >= 0; j--) {
                if (curVal < arr[j]) {
                    arr[j + 1] = arr[j];
                } else break;
            }

            arr[j + 1] = curVal;
        }
    }

    static void shellSort(int[] arr) {

    }
}
