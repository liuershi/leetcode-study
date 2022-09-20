package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/21 12:47 上午
 * @Version 1.0
 */
public class Demo304 {

    class NumMatrix {

        int[][] memo;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length, col = matrix[0].length;
            memo = new int[row + 1][col + 1];
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return memo[row2 + 1][col2 + 1] - memo[row2 + 1][col1] - memo[row1][col2 + 1] + memo[row1][col1];
        }
    }
}
