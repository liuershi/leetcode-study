package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/11/9 8:07 下午
 * @Version 1.0
 */
public class Demo764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int size = n * n;
        if (mines.length >= size)
            return 0;

        int[][] matrix = new int[n][n];
        for (int[] ints : matrix) {
            Arrays.fill(ints, 1);
        }

        for (int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 0;
        }

        int rsp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int len = 1, increment = 1;
                    while (i - increment >= 0 && i + increment < n && j - increment >= 0 && j + increment < n) {
                        if (matrix[i - increment][j] == 0
                            || matrix[i + increment][j] == 0
                            || matrix[i][j - increment] == 0
                            || matrix[i][j + increment] == 0)
                            break;
                        increment++;
                    }
                    rsp = Math.max(rsp, increment);
                }
            }
        }

        return rsp;
    }
}
