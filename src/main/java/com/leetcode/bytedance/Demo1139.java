package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/2/17 7:42 下午
 * @Version 1.0
 */
public class Demo1139 {

    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int row = grid.length, col = grid[0].length;
            int[][][] dp = new int[row][col][2];
            int max = 0;
            if (grid[0][0] == 1) {
                dp[0][0] = new int[]{1, 1};
                max = 1;
            }
            for (int i = 1; i < col; i++) {
                if (grid[0][i] == 1) {
                    dp[0][i] = new int[]{dp[0][i - 1][0] + 1, 1};
                    max = 1;
                }
            }
            for (int i = 1; i < row; i++) {
                if (grid[i][0] == 1) {
                    dp[i][0] = new int[]{1, dp[i - 1][0][1] + 1};
                    max = 1;
                }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (grid[i][j] == 1) {
                        dp[i][j] = new int[]{dp[i][j - 1][0] + 1, dp[i - 1][j][1] + 1};
                        if (dp[i][j][0] == dp[i][j][1]) {
                            max = Math.max(max, dp[i][j][0]);
                        }
                    }
                }
            }

            return max * max;
        }
    }
}
