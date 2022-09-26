package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/26 10:15 下午
 * @Version 1.0
 */
public class Offer47 {

    public int maxValue(int[][] grid) {
        // 思路：用相同大小矩阵记录每个位置的最大值
        // 时间和空间复杂度都为：O(m*n)
        int row = grid.length, col = grid[0].length;
        int[][] memo = new int[row][col];
        memo[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            memo[0][i] = memo[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
            }
        }
        return memo[row - 1][col - 1];
    }
}
