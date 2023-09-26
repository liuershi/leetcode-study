package com.leetcode.hot100.hash;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/9/26 10:00 下午
 * @Version 1.0
 */
public class Hot128 {

    public int longestConsecutive(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            return len;
        }
        Arrays.sort(nums);
        int count = 1, max = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                max = Math.max(max, ++count);
            } else {
                count = 1;
            }
        }

        return max;
    }
}
