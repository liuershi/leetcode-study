package com.leetcode.bytedance;

/**
 * 打家劫舍
 *
 * @Author milindeyu
 * @Date 2022/7/30 3:48 下午
 * @Version 1.0
 */
public class Demo198 {

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) memo[i] = Math.max(memo[i - 1], nums[i]);
            else {
                memo[i] = Math.max(memo[i - 2] + nums[i], memo[i - 1]);
            }
        }
        return memo[nums.length - 1];
    }
}
