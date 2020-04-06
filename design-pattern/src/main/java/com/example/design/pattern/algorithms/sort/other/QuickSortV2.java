package com.example.design.pattern.algorithms.sort.other;

import java.util.Random;

public class QuickSortV2 {
    public static void main(String[] args) {
        int[] arr = arr(10);
        arr = new int[]{1, 4, 3, 7, 2, 5, 8,3};

        print(arr);

        sort(arr, 0, arr.length - 1);

        print(arr);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = partition(arr, left, right);

        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left  = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left]  <= pivot) left++;
            while (left <= right && arr[right] >  pivot) right--;

            if (left < right) swap(arr, left, right);
        }

        swap(arr, left, rightBound);

        return left;
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
