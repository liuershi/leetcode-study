package com.leetcode.weekly.week323;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/12/11 10:30 上午
 * @Version 1.0
 */
public class Demo6257 {

    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        int row = grid.length,  col = grid[0].length;
        for (int i = 0; i < row; i++) {
            Arrays.sort(grid[i]);
        }
        for (int i = 0; i < col; i++) {
            int max = 0;
            for (int j = 0; j < row; j++) {
                max = Math.max(max, grid[j][i]);
            }
            res += max;
        }
        return res;
    }
}
