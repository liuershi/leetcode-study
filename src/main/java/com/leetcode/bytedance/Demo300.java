package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/3/23 10:38 下午
 * @Version 1.0
 */
public class Demo300 {

    public int lengthOfLIS(int[] nums) {
//        return method1(nums);

        // 方法二：基于动态规划
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 二分法实现
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
        int[] res = new int[nums.length];

        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0 ? -idx - 1: idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        Demo300 demo300 = new Demo300();
        System.out.println(demo300.lengthOfLIS(nums));
    }
}
