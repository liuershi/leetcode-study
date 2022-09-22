package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/27 4:20 下午
 * @Version 1.0
 */
public class Demo240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路二：Z字形查询，时间复杂度 O(m + n)
        // 由于每行最右边最大，且每列最下一行最大，所以从第一行最右边开始，若当
        // 前值小于目标值，则说明目标值在下面的行，则查询下一行，否则认为目标值
        // 可能在当前值的左边，向左移动
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col ] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    /**
     * 思路一：暴力查询
     * 时间复杂度：O(m * n)
     * @param matrix
     * @param target
     * @return
     */
    private boolean method1(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (target >= matrix[i][0]) {
                if (target <= matrix[i][col - 1] && binarySearch(matrix[i], target)) return true;
            } else break;
        }
        return false;
    }

    private boolean binarySearch(int[] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (matrix[middle] == target) return true;
            else if (matrix[middle] > target) right = middle - 1;
            else left = middle + 1;
        }
        return false;
    }
}
