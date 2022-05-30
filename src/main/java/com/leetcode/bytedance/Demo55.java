package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/22 9:50 下午
 * @Version 1.0
 */
public class Demo55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;

        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n)
                n = 1;
            else
                n++;

            if (i == 0 && n > 1)
                return false;
        }
        return true;
    }
}
