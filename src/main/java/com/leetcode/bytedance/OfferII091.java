package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/6/25 2:31 下午
 * @Version 1.0
 */
public class OfferII091 {

    public int minCost(int[][] costs) {
        // 动态规划实现
        int n = costs.length;
        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) {
            dp[i] = costs[0][i];
        }

        for (int i = 1; i < n; i++) {
            int[] newDp = new int[3];
            for (int j = 0; j < 3; j++) {
                newDp[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = newDp;
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    public static void main(String[] args) {
        OfferII091 offerII091 = new OfferII091();
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};
        System.out.println(offerII091.minCost(costs));
    }
}
