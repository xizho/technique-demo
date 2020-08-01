package com.example.design.pattern.algorithms;

import java.util.Arrays;

/**
 * 完成[1,2,3] + 1 = [1,2,4]
 *
 * @author xizho
 */
public class ArrayPlus {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int addNum = 1;
        System.out.println("原始数组：" + Arrays.toString(arr));
        System.out.println("结果数组：" + Arrays.toString(plusArr(arr, addNum)));
    }

    private static int[] plusArr(int[] arr, int addNum) {
        // 从最后一位开始加
        for (int i = arr.length - 1; i >= 0; i--) {
            // 当前位的值 + addNum的结果
            int plusRes = arr[i] + addNum;

            // 如果结果大于9，则需要进位
            if (plusRes > 9) {
                // 获取十位的数字
                int tenBit = plusRes / 10;
                // 获取个位的数字
                int oneBit = plusRes % 10;
                // 将个位数字赋值给当前位置
                arr[i] = oneBit;
                // 将十位的数字赋给addNum，进行下一个i位置的加法
                addNum = tenBit;

                // TODO 注意：这里需要特别判断下0位置的情况，需要扩容现有数组
                if (i == 0) {
                    int[] resArr = new int[arr.length + 1];
                    // 将原数组的值复制到新数组，且新数组从1位置开始，0位置需要空出来
                    System.arraycopy(arr, 0, resArr, 1, arr.length);
                    System.out.println("此时的resArr：" + Arrays.toString(resArr));
                    // 给0位置赋值
                    resArr[0] = addNum;
                    // 将新数组赋值给原数组
                    arr = resArr;
                }
            } else {
                // 如果结果不大于9，直接赋值
                arr[i] = plusRes;
                // TODO 注意：由于结果不大于9，所以不需要向前进位，此时需要置addNum为0
                addNum = 0;
            }
        }

        return arr;
    }

}
