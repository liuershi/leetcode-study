package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/14 6:19 下午
 * @Version 1.0
 */
public class Demo746 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // 该数组定义为到达该点的最小花费
        int[] dp = new int[n + 1];
        // 可以从0和1开始，所以下标0和1的花费都为0
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Demo746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
