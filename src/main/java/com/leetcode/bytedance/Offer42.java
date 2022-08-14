package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/14 5:55 下午
 * @Version 1.0
 */
public class Offer42 {

    public int maxSubArray(int[] nums) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
