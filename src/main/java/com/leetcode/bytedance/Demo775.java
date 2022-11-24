package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/16 12:21 上午
 * @Version 1.0
 */
public class Demo775 {

    public boolean isIdealPermutation(int[] nums) {
//        return method1(nums);
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1)
                return false;
        }
        return true;
    }

    /**
     * 暴力循环
     *
     * 时间复杂度：o(N^2) 会超时
     *
     * @param nums
     * @return
     */
    private boolean method1(int[] nums) {
        int global = 0, local = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) global++;
                if (global >= n) return false;
            }
            if (nums[i] > nums[i + 1]) local++;
        }
        return global == local;
    }
}
