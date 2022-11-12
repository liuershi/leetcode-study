package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/11/12 7:10 下午
 * @Version 1.0
 */
public class Demo790 {

    public int numTilings(int n) {
        int divisor = (int) 1e9 + 7;
        // 记录当前第i个瓷砖的状态
        // dp二维的4记录当前第i列的瓷砖状态，0：上下都未铺；1：上面瓷砖铺了；2：下面瓷砖铺了；3：上下的瓷砖都铺了
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % divisor;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % divisor;
            dp[i][3] = ((dp[i - 1][0] + dp[i - 1][1]) % divisor + (dp[i - 1][2] + dp[i - 1][3]) % divisor) % divisor;
        }
        return dp[n][3];
    }
}
