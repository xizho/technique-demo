package com.example.design.pattern.algorithms.dp;

/**
 * 机器人从左上角走动右下角，可能的路径有几种？
 */
public class RobotPath {
    public static void main(String[] args) {
        int num = dp(3, 4);
        print(num);
    }

    static int dp(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }

        return f[m - 1][n - 1];
    }

    static void print(int num) {
        System.out.println(num);
    }
}
