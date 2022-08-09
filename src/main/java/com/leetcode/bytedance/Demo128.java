package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/17 10:10 下午
 * @Version 1.0
 */
public class Demo128 {

    public int longestConsecutive(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2) return len;
        Arrays.sort(nums);
        int rsp = 0;
        int prev = nums[len - 1], count = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] == nums[i]) continue;
            if (prev == nums[i] + 1) count++;
            else {
                rsp = Math.max(rsp, count);
                count = 1;
            }
            prev = nums[i];
        }
        return Math.max(rsp, count);
    }
}
