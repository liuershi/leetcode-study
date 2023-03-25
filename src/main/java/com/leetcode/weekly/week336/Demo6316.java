package com.leetcode.weekly.week336;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/3/12 10:39 上午
 * @Version 1.0
 */
public class Demo6316 {

    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum <= 0) {
                return nums.length - i - 1;
            }
        }
        return nums.length;
    }
}
