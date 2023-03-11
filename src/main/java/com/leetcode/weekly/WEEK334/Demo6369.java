package com.leetcode.weekly.WEEK334;

/**
 * @Author milindeyu
 * @Date 2023/2/26 10:31 上午
 * @Version 1.0
 */
public class Demo6369 {

    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n], left = new int[n], right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] + right[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(right[i] - left[i]);
        }
        return res;

    }
}
