package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/10/12 9:12 下午
 * @Version 1.0
 */
public class Demo2562 {

    public long findTheArrayConcVal(int[] nums) {
        long val = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                val += nums[left];
                break;
            }
            val += Long.parseLong(nums[left++] + "" + nums[right--] + "");
        }
        return val;
    }
}
