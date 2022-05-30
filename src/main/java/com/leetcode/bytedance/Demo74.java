package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/24 11:36 下午
 * @Version 1.0
 */
public class Demo74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        /**
         * 总体思路是先判断目标值是否在当前行范围内，若在则逐行遍历，若在范围内则二分判断
         */

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int start = matrix[i][0];
                int end = matrix[i][n - 1];
                if (target < start)
                    return false;
                if (target > end)
                    break;

                if (target == start || target == end)
                    return true;
                int left = 0, right = n - 1;
                // 需要允许左右节点相等，因为存在刚好某个节点在左右位置相同是为目标值
                while (left <= right) {
                    int middle = (left + right) / 2;
                    if (matrix[i][middle] == target)
                        return true;
                    else if (matrix[i][middle] > target)
                        right = middle - 1;
                    else
                        left = middle + 1;
                }
            }
        }

        return false;
    }
}
