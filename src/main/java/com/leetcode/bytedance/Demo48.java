package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/22 3:57 下午
 * @Version 1.0
 */
public class Demo48 {

    public void rotate(int[][] matrix) {
        // 先上下对折，再对角线对折
        int height = matrix.length;
        int width = matrix[0].length;
        int upAndDown = height / 2;

        // 上下对折
        for (int i = 0; i < upAndDown; i++) {
            for (int j = 0; j < width; j++) {
                int top = matrix[i][j];
                int down =  matrix[height - i - 1][j];
                matrix[i][j] = down;
                matrix[height - i - 1][j] = top;
            }
        }

        // 对角线对折
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j) {
        int val1 = matrix[i][j];
        int val2 = matrix[j][i];
        matrix[i][j] = val2;
        matrix[j][i] = val1;
    }
}
