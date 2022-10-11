package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/10/11 10:41 下午
 * @Version 1.0
 */
public class Demo0107 {

    public void rotate(int[][] matrix) {
        // 要求：不占用额外空间
        // 思路：将矩阵先上下对折，再左上角和右下角斜线对折
        int N = matrix.length;

        int middle = N >> 1;
        // 上下对折
        for (int i = 0; i < middle; i++) {
            for (int j = 0; j < N; j++) {
                swap(matrix, i, j, N - i - 1, j);
            }
        }

        // 斜角对折
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }
}
