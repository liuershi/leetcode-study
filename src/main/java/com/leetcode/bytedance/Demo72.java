package com.leetcode.bytedance;

import java.util.Optional;

/**
 * @Author milindeyu
 * @Date 2022/5/7 11:50 下午
 * @Version 1.0
 */
public class Demo72 {

    public int minDistance(String word1, String word2) {
        Integer l1 = word1 == null ? 0 : word1.length();
        Integer l2 = word2 == null ? 0 : word2.length();

        if (l1 == 0 || l2 == 2)
            return l1 == 0 ? l2 : l1;

        word1 = " " + word1;
        word2 = " " + word2;

        int[][] matrix = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l2; i++) {
            matrix[0][i] = i;
        }
        for (int i = 0; i <= l1; i++) {
            matrix[i][0] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    matrix[i][j] = matrix[i - 1][j - 1];
                else {
                    int top = matrix[i - 1][j];
                    int left = matrix[i][j - 1];
                    int topAndLeft = matrix[i - 1][j - 1];
                    matrix[i][j] = Math.min(Math.min(left, top), topAndLeft) + 1;
                }
            }
        }

        return matrix[l1][l2];
    }
}
