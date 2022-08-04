package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/5 1:10 上午
 * @Version 1.0
 */
public class Offer53II {

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) right = mid;
            else left = mid + 1;
        }
        return left == nums.length - 1 && nums[left] == left ? left + 1 : left;
    }
}
