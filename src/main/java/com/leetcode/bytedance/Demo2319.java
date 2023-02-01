package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/31 7:15 下午
 * @Version 1.0
 */
public class Demo2319 {

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    if (grid[i][j] == 0) return false;
                } else if (grid[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
}
