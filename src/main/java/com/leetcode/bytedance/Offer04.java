package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/8/2 18:12
 */
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int min = matrix[i][0], max = matrix[i][n - 1];
            if (target <= min) return target == min;
            else if (target > max) continue;
            else {
                int left = 1, right = n - 1;
                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    if (matrix[i][middle] == target) return true;
                    else if (matrix[i][middle] < target) left = middle + 1;
                    else right = middle - 1;
                }
            }
        }
        return false;
    }
}
