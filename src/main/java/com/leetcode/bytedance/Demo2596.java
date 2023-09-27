package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/9/13 9:38 下午
 * @Version 1.0
 */
public class Demo2596 {

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        return traceBack(grid, 0, 0, n, 0);
    }

    private boolean traceBack(int[][] grid, int i, int j, int n, int val) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == -1 || grid[i][j] != val) {
            return false;
        }
        if (val == n * n - 1) {
            return true;
        }
        grid[i][j] = -1;
        return traceBack(grid, i - 1, j - 2, n, val + 1)
                || traceBack(grid, i - 1, j + 2, n, val + 1)
                || traceBack(grid, i + 1, j - 2, n, val + 1)
                || traceBack(grid, i + 1, j + 2, n, val + 1)
                || traceBack(grid, i - 2, j - 1, n, val + 1)
                || traceBack(grid, i - 2, j + 1, n, val + 1)
                || traceBack(grid, i + 2, j - 1, n, val + 1)
                || traceBack(grid, i + 2, j + 1, n, val + 1);
    }
}
