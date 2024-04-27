package com.leetcode.bytedance;

import com.leetcode.test.top150.Demo27;

/**
 * @Author fishball
 * @Date 2024/3/14 10:08 下午
 * @Version 1.0
 */
public class Demo2789 {

    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? nums[i] + sum : nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {59,17,33};
        System.out.println(new Demo2789().maxArrayValue(nums));
    }
}
