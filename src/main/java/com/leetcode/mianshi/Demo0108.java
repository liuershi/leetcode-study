package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/10/1 12:08 上午
 * @Version 1.0
 */
public class Demo0108 {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) rows[i] = cols[j] = true;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rows[i] || cols[j]) matrix[i][j] = 0;
            }
        }
    }
}
