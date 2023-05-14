package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/5/13 12:42 上午
 * @Version 1.0
 */
public class Demo2441 {

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int lv = nums[left], rv = nums[right];
            if (lv == -rv) {
                return Math.abs(lv);
            } else if (rv > -lv) {
                right--;
            } else {
                left++;
            }
        }
        return -1;
    }
}
