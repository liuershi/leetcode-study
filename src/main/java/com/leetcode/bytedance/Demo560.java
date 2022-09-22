package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/20 9:44 下午
 * @Version 1.0
 */
public class Demo560 {

    public int subarraySum(int[] nums, int k) {
        // 方法一：暴力，双层循环
        int res = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) res++;
            }
        }
        return res;
    }
}
