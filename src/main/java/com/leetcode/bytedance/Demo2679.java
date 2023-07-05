package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/7/4 12:07 上午
 * @Version 1.0
 */
public class Demo2679 {

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int row = nums.length, col = nums[0].length;
        int sum = 0, max = 0;
        for (int i = col - 1; i >= 0; i--) {
            max = 0;
            for (int j = 0; j < row; j++) {
                max = Math.max(max, nums[j][i]);
            }
            sum += max;
        }
        return sum;
    }
}
