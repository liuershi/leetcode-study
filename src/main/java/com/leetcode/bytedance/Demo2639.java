package com.leetcode.bytedance;

/**
 * @Author fishball
 * @Date 2024/4/27 6:36 下午
 * @Version 1.0
 */
public class Demo2639 {
    public int[] findColumnWidth(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] ans = new int[col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int length = 0;
                int value = grid[j][i];
                if (value <= 0) {
                    length++;
                }
                while (value != 0) {
                    value /= 10;
                    length++;
                }
                ans[i] = Math.max(ans[i], length);
            }
        }
        return ans;
    }
}
