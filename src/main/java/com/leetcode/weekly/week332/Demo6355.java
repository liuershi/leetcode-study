package com.leetcode.weekly.week332;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/2/12 10:40 上午
 * @Version 1.0
 */
public class Demo6355 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int r = lowerBound(nums, i, upper - nums[i] + 1);
            int l = lowerBound(nums, i, lower - nums[i]);
            res += r - l + 1;
        }
        return res;
    }

    private int lowerBound(int[] nums, int right, int target) {
        int left = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
