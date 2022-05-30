package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/4/28 11:17 下午
 * @Version 1.0
 */
public class Demo62 {

    public static int uniquePaths1(int m, int n) {
        return process1(m, n, 1, 1);
    }

    /**
     * 该种方式为暴力递归，leetcode会超时
     * @param m
     * @param n
     * @param x
     * @param y
     * @return
     */
    private static int process1(int m, int n, int x, int y) {
        if (x == m && y == n) {
            return 1;
        }
        if (x == m) {
            return process1(m, n, x, y + 1);
        }
        if (y == n) {
            return process1(m, n, x + 1, y);
        }
        return process1(m, n, x + 1, y) + process1(m, n, x, y + 1);
    }

    public static int uniquePaths2(int m, int n) {
        // 使用记忆表存储重复的结果，相当于缓存
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(m, n, 1, 1, dp);
    }

    /**
     * 使用记忆表的方式
     * @param m
     * @param n
     * @param x
     * @param y
     * @return
     */
    private static int process2(int m, int n, int x, int y, int[][] dp) {
        // 命中记忆表的缓存时
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        if (x == m && y == n) {
            dp[x][y] = 1;
            return 1;
        }
        if (x == m) {
            dp[x][y] = process2(m, n, x, y + 1, dp);
            return dp[x][y];
        }
        if (y == n) {
            dp[x][y] = process2(m, n, x + 1, y, dp);
            return dp[x][y];
        }
        dp[x][y] = process2(m, n, x + 1, y, dp) + process2(m, n, x, y + 1, dp);
        return dp[x][y];
    }



    public static void main(String[] args) {
//        System.out.println(uniquePaths1(3, 7));
        System.out.println(uniquePaths2(51, 9));
    }
}
