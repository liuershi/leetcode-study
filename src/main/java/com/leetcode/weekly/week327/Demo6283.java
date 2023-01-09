package com.leetcode.weekly.week327;

/**
 * @Author milindeyu
 * @Date 2023/1/8 10:31 上午
 * @Version 1.0
 */
public class Demo6283 {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num > 0)
                pos++;
            else if (num < 0)
                neg++;
        }
        return Math.max(pos, neg);
    }
}
