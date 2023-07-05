package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/27 10:20 下午
 * @Version 1.0
 */
public class Demo1186 {

    public int maximumSum(int[] arr) {

        int len = arr.length;
        int[][] dp = new int[len][2];

        int max = arr[0];
        dp[0][0] = dp[0][1] = arr[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        return max;
    }
}
