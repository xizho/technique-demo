package com.example.design.pattern.algorithms.sort.other;

import java.util.Random;

public class RadixSortV2 {
    public static void main(String[] args) {
        int[] arr = arr(10);

        arr = new int[]{2, 0, 5, 3, 7, 1, 9, 4, 8, 6, 4};

        print(arr);

//        arr = sort(arr);
        arr = sortV2(arr);

        print(arr);
    }

    /**
     * 不稳定版本
     *
     * @param arr
     * @return
     */
    static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count  = new int[10];

        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        for (int i = 0, j = 0; i < count.length; i++)
            while (count[i]-- > 0)
                result[j++] = i;

        return result;
    }

    /**
     * 稳定版本
     *
     * @param arr
     * @return
     */
    static int[] sortV2(int[] arr) {
        int[] result = new int[arr.length];
        int[] count  = new int[10];

        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--)
            result[--count[arr[i]]] = arr[i];

        return result;
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
