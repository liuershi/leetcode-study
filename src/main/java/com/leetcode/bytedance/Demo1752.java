package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/27 12:05 上午
 * @Version 1.0
 */
public class Demo1752 {

    public boolean check(int[] nums) {
        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                diff++;
            }
            if (diff > 1) return false;
        }
        if (diff == 1 && nums[nums.length - 1] > nums[0]) {
            return false;
        }
        return true;
    }
}
