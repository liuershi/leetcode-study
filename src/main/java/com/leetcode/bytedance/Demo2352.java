package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/6 12:07 上午
 * @Version 1.0
 */
public class Demo2352 {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (equal(i, j, n, grid)) {
                    ans++;
                }
            }
        }
        
        return ans;
    }

    private boolean equal(int row, int col, int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
