package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/5 9:40 下午
 * @Version 1.0
 */
public class Demo2460 {

    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (i == nums.length - 1) {
                ans[start++] = nums[i];
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                ans[start++] = nums[i] * 2;
                nums[i + 1] = 0;
            } else {
                ans[start++] = nums[i];
            }
        }
        return ans;
    }
}
