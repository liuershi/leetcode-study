package com.leetcode.weekly.week320;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/11/20 11:03 上午
 * @Version 1.0
 */
public class Demo6244 {

    public int beautifulPartitions(String s, int k, int minLength) {
        int n = s.length();
        // 特判，边界条件
        if (k * minLength > n || !prime(s.charAt(0)) || prime(s.charAt(n - 1)))
            return 0;

        int mod = (int) 1e9 + 7;
        // 表示将长度为n的字符分为k段的方案数，每段都满足题目的要求
        int[][] dp = new int[k + 1][n + 1];
        dp[0][0] = 1; // 表示将长度为0的字符分为0段的方案数

        for (int i = 1; i <= k; i++) {
            int sum = 0;
            for (int j = i * minLength; j + (k - i) * minLength <= n; j++) {
                if (canPartition(s, j - minLength)) sum = (sum + dp[i - 1][j - minLength]) % mod;
                if (canPartition(s, j)) dp[i][j] = sum;
            }
        }

        return dp[k][n];
    }

    /**
     * 判断能否在 j - 1 和 j 之间将字符串s分割
     * @param s
     * @param j
     * @return
     */
    private boolean canPartition(String s, int j) {
        return j == 0 || j == s.length() || !prime(s.charAt(j - 1)) && prime(s.charAt(j));
    }

    /**
     * 当前字符是否为质数
     * @param c
     * @return
     */
    private boolean prime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    public static void main(String[] args) {
        Demo6244 demo6244 = new Demo6244();
        String str = "23542185131";
        System.out.println(demo6244.beautifulPartitions(str, 3, 2));
    }
}
