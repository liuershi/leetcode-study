package com.leetcode.bytedance;


import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2024/2/2 7:19 下午
 * @Version 1.0
 */
public class Demo1686 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            memo[i][0] = aliceValues[i] + bobValues[i];
            memo[i][1] = aliceValues[i];
            memo[i][2] = bobValues[i];
        }

        Arrays.sort(memo, (a, b) -> b[0] - a[0]);

        int aliceSum = 0, bobSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceSum += memo[i][1];
            } else {
                bobSum += memo[i][2];
            }
        }

        return Integer.compare(aliceSum, bobSum);
    }
}
