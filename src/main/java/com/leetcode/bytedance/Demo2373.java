package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/3/1 12:10 上午
 * @Version 1.0
 */
public class Demo2373 {

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] memo = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = 0;
                for (int row = i - 1; row <= i + 1 ; row++) {
                    for (int col = j - 1; col <= j + 1; col++) {
                        max = Math.max(max, grid[row][col]);
                    }
                }
                memo[i - 1][j - 1] = max;
            }
        }
        return memo;
    }

    public static void main(String[] args) {
        int[][] nums = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        for (int[] ints : largestLocal(nums)) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
