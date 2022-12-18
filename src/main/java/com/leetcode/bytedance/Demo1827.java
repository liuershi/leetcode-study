package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/11 12:05 上午
 * @Version 1.0
 */
public class Demo1827 {

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
