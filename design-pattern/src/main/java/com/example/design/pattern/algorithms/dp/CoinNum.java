package com.example.design.pattern.algorithms.dp;

/**
 * 给出2，5，7元硬币，凑出27元，求最少需要多少枚硬币？
 */
public class CoinNum {
    public static void main(String[] args) {
        int x = 5;
        int num = recursion(x);
        System.out.println(num);

        int[] A = new int[]{2, 5, 7};
        num = dp(A, 27);
        System.out.println(num);
    }

    /**
     * 递归 // TODO 不对的，有问题
     */
    static int recursion(int x) {
        if (x == 0) return 0;

        int res = Integer.MAX_VALUE;

        if (x >= 2) res = Math.min(recursion(x - 2) + 1, res);

        if (x >= 5) res = Math.min(recursion(x - 5) + 1, res);

        if (x >= 7) res = Math.min(recursion(x - 7) + 1, res);

        return res;
    }

    /**
     * 动态规划
     */
    static int dp(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;
        // 1. 初始条件
        f[0] = 0;
        for (int i = 1; i <= M; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++)
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE)
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
        }

        if (f[M] == Integer.MAX_VALUE) {
            f[M] = -1;
        }

        return f[M];
    }

}
