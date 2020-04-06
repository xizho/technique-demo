package com.example.design.pattern.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {

        validAlgorithms(1000);
    }


    static void validAlgorithms(int size) {
        int[] arr1 = generatorArr(size);
//        System.out.println("第一个数组：" + Arrays.toString(arr1));
        int[] arr2 = new int[size];
        System.arraycopy(arr1, 0, arr2, 0, size);
//        System.out.println("第二个数组：" + Arrays.toString(arr2));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("JDK中的Arrays.sort性能：");
        arraysSort(arr1);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("自己写的选择排序性能：");
        selectSortSelf(arr2);
    }


    static void arraysSort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("排序前：" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start));
    }

    static void selectSortSelf(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("排序前：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start));
    }

    static int[] generatorArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt(size);
        }


        return arr;
    }


    static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            // 找出本次循环中的最小值位置，必须
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    // TODO 不能在里层循环中交换最小值，不然会导致0 ~ i的数字无序
                   /* int temp = arr[j];
                    arr[j] = arr[minPos];
                    arr[minPos] = temp;*/

                    minPos = j;
                }
            }

//            System.out.print("第" + (i + 1) + "次中获得的最小值为：" + arr[minPos]);
            // 在外层循环中交换最小值
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;

            /*System.out.print("，内层循环排序后的数组：");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();*/
        }

        /*System.out.print("排序后的数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }


    static void selectSortOp() {
        int[] arr = {3, 6, 2, 9, 8, 1, 5, 4, 7};
        System.out.print("原数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        /*
         * 思路分析
         */



        /* 1. 找到最小的元素并打印 */

        // 初始化最小元素的位置为0
        int minPos0 = 0;
        for (int j = 1; j < arr.length; j++) {
            System.out.println("当前位置" + j + "，当前元素：" + arr[j] + "，当前最小元素：" + arr[minPos0]);
            if (arr[j] < arr[minPos0]) {
                minPos0 = j;
                System.out.println("min pos is " + j);
            }
        }

        System.out.println("/********************************************************/");
        selectSort(arr);

        System.out.println();
    }
}
