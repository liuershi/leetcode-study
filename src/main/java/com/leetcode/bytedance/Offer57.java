package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/9 12:00 上午
 * @Version 1.0
 */
public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (left == right) {
            if (nums[left] == target) return nums;
        } else {
            while (left < right) {
                if (nums[right] >= target) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum < target) left++;
                else if (sum > target) {
                    if (nums[left + 1] + nums[right] > target) right--;
                    else left++;
                } else return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
