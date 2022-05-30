package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/5/24 11:04 下午
 * @Version 1.0
 */
public class Demo73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> lines = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    rows.add(i);
                    lines.add(j);
                }
            }
        }


        for (Integer row : rows) {
            Arrays.fill(matrix[row], 0);
        }
        for (Integer line : lines) {
            for (int i = 0; i < m; i++) {
                matrix[i][line] = 0;
            }
        }
    }

}
