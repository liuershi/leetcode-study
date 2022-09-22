package com.leetcode.weekly.nio.week306;

/**
 * @Author milindeyu
 * @Date 2022/8/14 10:32 上午
 * @Version 1.0
 */
public class Demo6148 {

    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - 2][n - 2];
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = maxValue(i + 1, j + 1, grid);
            }
        }
        return res;
    }

    private int maxValue(int i, int j, int[][] grid) {
        int max = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                max = Math.max(max, grid[k][l]);
            }
        }
        return max;
    }
}
