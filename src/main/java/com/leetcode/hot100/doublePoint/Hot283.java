package com.leetcode.hot100.doublePoint;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/9/26 10:17 下午
 * @Version 1.0
 */
public class Hot283 {

    public void moveZeroes(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) < 2) {
            return;
        }

        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        Arrays.fill(nums, idx, len, 0);
    }
}
