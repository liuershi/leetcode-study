package com.leetcode.weekly.twoweek.week89;

/**
 * @Author milindeyu
 * @Date 2022/10/15 11:34 下午
 * @Version 1.0
 */
public class Demo6210 {

    public int minimizeArrayValue(int[] nums) {
        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[] nums, int mid) {
        long have = 0;
        for (int num : nums) {
            if (num <= mid) {
                have += mid - num;
            } else {
                if (num - mid > have) return false;
                else have -= num - mid;
            }
        }
        return true;
    }
}
