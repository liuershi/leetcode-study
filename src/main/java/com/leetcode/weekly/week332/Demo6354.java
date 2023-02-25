package com.leetcode.weekly.week332;

/**
 * @Author milindeyu
 * @Date 2023/2/12 10:30 上午
 * @Version 1.0
 */
public class Demo6354 {

    public long findTheArrayConcVal(int[] nums) {
        int left = 0, right = nums.length - 1;
        long res = 0;
        while (left <= right) {
            if (left == right) {
                res += nums[left];
                break;
            } else {
                long val = Long.parseLong(nums[left] + String.valueOf(nums[right]));
                res +=  val;
            }
            left++;
            right--;
        }
        return res;
    }
}
