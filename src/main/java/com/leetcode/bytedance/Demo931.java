package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/7/13 9:51 下午
 * @Version 1.0
 */
public class Demo931 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (col == 0) {
                    matrix[row][col] += Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]);
                } else if (col == n - 1) {
                    matrix[row][col] += Math.min(matrix[row - 1][col - 1], matrix[row - 1][col]);
                } else {
                    matrix[row][col] += Math.min(Math.min(matrix[row - 1][col - 1], matrix[row - 1][col]), matrix[row - 1][col + 1]);
                }
            }
        }
        Arrays.sort(matrix[n - 1]);
        return matrix[n - 1][0];
    }
}
