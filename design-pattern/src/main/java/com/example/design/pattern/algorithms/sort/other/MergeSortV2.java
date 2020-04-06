package com.example.design.pattern.algorithms.sort.other;

import java.util.Random;

public class MergeSortV2 {
    public static void main(String[] args) {
        int[] arr = arr(10);

//        arr = new int[]{1, 4, 6, 7, 2, 3, 8};
//        arr = new int[]{1, 4, 6, 7, 5, 3, 8};

        print(arr);

//        sort(arr);
        sort(arr, 0, arr.length - 1);

        print(arr);
    }

    static void sort(int[] arr) {
//      arr = merge(arr);
        merge(arr, 0, 4, arr.length - 1);
    }

    static void sort(int[] arr, int left, int right) {
        if (left == right) return;

        // 分成左右两部分
        int mid = left + (right - left) / 2;
        // 左边排序
        sort(arr, left, mid);
        // 右边排序
        sort(arr, mid + 1, right);
        // 合并排序结果了，即归并了

        merge(arr, left, mid + 1, right);
    }

    static void merge(int[] arr, int leftPoint, int rightPoint, int rightBound) {
        int mid = rightPoint - 1;
        int[] temp = new int[rightBound - leftPoint + 1];

        int i = leftPoint;
        int j = rightPoint;
        int k = 0;

        /*
            左右游标所在的值，进行比较。
            i的值<=j的值，i的游标右移即+1，同时k的游标，即临时数组的游标，右移。
            此时，当前的i再和j比较。
            i的值>j的值 ，j的游标右移即+1，同时k的游标，即临时数组的游标，右移
            此时，当前的i再和j比较。
            ...
            ...
         */
        while (i <= mid && j <= rightBound) temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        /* 左边剩余数据直接移到temp*/
        while (i <= mid) temp[k++] = arr[i++];
        /* 右边剩余数据直接移到temp*/
        while (j <= rightBound) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) arr[leftPoint + l] = temp[l];
    }

    static int[] merge(int[] arr) {
        int length = arr.length;
        int mid = length / 2;
        int[] temp = new int[length];

        int i = 0;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j < length) temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        while (i <= mid) temp[k++] = arr[i++];
        while (j < length) temp[k++] = arr[j++];

        return temp;
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
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

        System.out.println();
    }

}
