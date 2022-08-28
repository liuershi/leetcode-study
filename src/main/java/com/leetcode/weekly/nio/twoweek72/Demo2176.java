package com.leetcode.weekly.nio.twoweek72;

/**
 * @Author milindeyu
 * @Date 2022/8/27 10:42 下午
 * @Version 1.0
 */
public class Demo2176 {

    public int countPairs(int[] nums, int k) {
        int n = nums.length, res = 0;
        if (n == 1) return res;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) res++;
            }
        }
        return res;
    }
}
