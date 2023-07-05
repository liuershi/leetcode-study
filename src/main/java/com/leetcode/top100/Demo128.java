package com.leetcode.top100;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/6/24 9:26 下午
 * @Version 1.0
 */
public class Demo128 {

    public int longestConsecutive(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 2) {
            return len;
        }
        Arrays.sort(nums);
        int max = 1, count = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] == nums[i]) {
                continue;
            }
            if (nums[i] + 1 == nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
