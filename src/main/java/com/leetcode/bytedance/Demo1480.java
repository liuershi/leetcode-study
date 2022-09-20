package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/27 9:41 下午
 * @Version 1.0
 */
public class Demo1480 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
