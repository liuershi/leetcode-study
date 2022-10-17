package com.leetcode.weekly.yinlian.week315;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/10/17 10:11 下午
 * @Version 1.0
 */
public class Demo2441 {

    public int findMaxK(int[] nums) {
        int rsp = -1;
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            if ((nums[left] > 0 && nums[right] > 0) ||
                    (nums[left] < 0 && nums[right] < 0))
                break;

            if (Math.abs(nums[left]) == nums[right]) {
                rsp = nums[right];
                break;
            } else if (Math.abs(nums[left]) > nums[right]){
                left++;
            } else {
                right--;
            }
        }
        return rsp;
    }
}
