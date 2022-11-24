package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/20 11:07 下午
 * @Version 1.0
 */
public class Demo799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        // 思路：动态规划

        // 记录第row行第glass个杯子存放的酒的比例
        double[][] dp = new double[101][101];
        // 初始时所有酒装在第一个杯子中
        dp[0][0] = poured;
        // 遍历所有酒杯
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] >= 1) {
                    // 当当前酒杯装满了时
                    double remain = dp[i][j] - 1; // 剩余的酒
                    dp[i][j] = 1;
                    // 剩余的酒分给该酒杯下面的两个酒杯
                    dp[i + 1][j] += remain / 2;
                    dp[i + 1][j + 1] += remain / 2;
                }
            }
        }

        return dp[query_row][query_glass];
    }
}
