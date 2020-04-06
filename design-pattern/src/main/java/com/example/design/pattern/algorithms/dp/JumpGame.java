package com.example.design.pattern.algorithms.dp;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] A = new int[]{0, 8, 2, 0, 9};
        boolean res = dp(A);
        print(res);
    }

    static boolean dp(int[] A) {
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;

        // 当前位置
        for (int i = 0; i < n; i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {
                if (f[j] && i + A[j] >= i) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n - 1];
    }

    static void print(boolean res) {
        System.out.println(res);
    }
}
