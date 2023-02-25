package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/2/22 9:44 下午
 * @Version 1.0
 */
public class Demo877 {

    public boolean stoneGame(int[] piles) {
        // 思路：动态规划
        int n = piles.length;
        // dp维护的是 i 到 j 下标之间，当前玩家和另一个玩家获得石子差值的最大值
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[i] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
