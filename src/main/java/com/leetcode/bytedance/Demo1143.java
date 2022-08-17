package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * 最长公共子序列
 *
 * @Author milindeyu
 * @Date 2022/8/17 11:53 下午
 * @Version 1.0
 */
public class Demo1143 {

    /**
     * 基于动态规划实现
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 注意：这里不能先去左和上的最大值再判断是否相等去加1，因为可能当前相等的值在前面也遇到了相同的字符
                    // 而导致重复加1了，例如："bsbininm"、"jmjkbkjkv"，在遍历字符串text2中字符'b'时重复计算了字符串text1
                    // 中的两个字符'b'
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 再取上、左、和当前值中的最大值为当前值
                dp[i][j] = Math.max(
                        Math.max(dp[i - 1][j], dp[i][j - 1]),
                        dp[i][j]
                );
            }
        }
        return dp[m][n];
    }
}
