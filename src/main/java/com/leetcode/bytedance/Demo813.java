package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/28 10:15 下午
 * @Version 1.0
 */
public class Demo813 {

    public double largestSumOfAverages(int[] nums, int k) {
        // 思路：dp + 前缀和
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        // 我们使用 dp[i][j] 表示 nums 在区间 [0, i-1] 被切分成 j 个子数组的最大平均值和
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i] / i;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                for (int l = i - 1; l < j; l++) {
                    dp[j][i] = Math.max(dp[j][i], dp[l][i - 1] + (prefix[j] - prefix[l]) / (j - l));
                }
            }
        }

        return dp[n][k];
    }
}
