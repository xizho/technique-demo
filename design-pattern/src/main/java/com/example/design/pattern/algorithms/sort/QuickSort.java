package com.example.design.pattern.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 7, 8, 1, 9, 5, 1, 3, 4};
//        arr = new int[]{6, 8, 7};
        System.out.println("排序前：" + Arrays.toString(arr));
        quickSortV1(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    static void quickSortV1(int[] arr) {
        quickSortV1(arr, 0, arr.length - 1);     // TODO 测试不通过
//        quickSortV2(arr, 0, arr.length - 1);    // TODO 挖坑法---------测试通过
    }

    /**
     * 单轴单向快排
     *
     * @param arr
     * @param head
     * @param tail
     */
    private static void quickSortV1(int[] arr, int head, int tail) {
        if (head < tail) {
            int left = head + 1, right = tail, pivot = arr[head];
            while (left <= right) {
                while (left <= right && arr[left] <= pivot) {
                    left++;
                }

                while (left <= right && arr[right] > pivot) {
                    right--;
                }

                // 交换俩数
                if (left < right) {
                    swap(arr, left, right);
                    left++;
                    right--;
                }

                System.out.println(Arrays.toString(arr));
            }
            System.out.println("left: " + left + ", right: " + right);

            swap(arr, head, right);

            quickSortV1(arr, head, right - 1);
            quickSortV1(arr, right + 1, tail);
        }
    }

    /**
     * 挖坑法是可行的，为什么上面那种不行
     *
     * @param arr
     * @param head
     * @param tail
     */
    private static void quickSortV2(int[] arr, int head, int tail) {
        if (head < tail) {
            int left = head, right = tail, pivot = arr[head];
            while (left < right) {
                // 从最右侧依此找一个比pivot小的数
                while (left < right && arr[right] >= pivot) {
                    right--;
                }
                // 放到left位置
                arr[left] = arr[right];
                // 从最左侧一次找一个比pivot大的数
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                // 放到right位置
                arr[right] = arr[left];
            }

            // 将pivot放到停止的位置，此时： left == right
            arr[left] = pivot;

            quickSortV2(arr, head, left);
            quickSortV2(arr, left + 1, tail);
        }
    }


    /**
     * 交换两个数字
     *
     * @param arr
     * @param left
     * @param right
     */
    static void swap(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        // 需第三个参数参与
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static void swap(int leftValue, int rightValue) {
        // 无需第三个参数，风险是两数之和可能超过int的范围
        /*arr[left]  = arr[left] + arr[right];
        arr[right] = arr[left] - arr[right];
        arr[left]  = arr[left] - arr[right];*/

        // 利用位运算，异或，高效
        leftValue = leftValue ^ rightValue;
        rightValue = leftValue ^ rightValue;
        leftValue = leftValue ^ rightValue;
    }

}
