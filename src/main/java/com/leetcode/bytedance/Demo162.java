package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/25 11:24 下午
 * @Version 1.0
 */
public class Demo162 {

    public int findPeakElement(int[] nums) {
        if (nums.length < 3) {
            return nums.length == 2 && nums[1] > nums[0] ? 1 : 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == 0 && nums[left] > nums[left + 1]) return left;
            if (left > 0 && nums[left] > nums[left - 1] && nums[left] > nums[left + 1]) return left;
            if (right == nums.length - 1 && nums[right] > nums[right - 1]) return right;
            if (right < nums.length - 1 && nums[right] > nums[right - 1] && nums[right] > nums[right + 1]) return right;
            left++;
            right--;
        }
        return 0;
    }
}
