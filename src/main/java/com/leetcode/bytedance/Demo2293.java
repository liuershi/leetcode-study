package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/15 10:22 上午
 * @Version 1.0
 */
public class Demo2293 {

    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            n >>= 1;
            int[] newNums = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }
}
