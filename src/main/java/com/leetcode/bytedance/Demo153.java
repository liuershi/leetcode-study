package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/24 6:35 下午
 * @Version 1.0
 */
public class Demo153 {

    public int findMin(int[] nums) {
//        return method01(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return nums[i];
        }
        return nums[0];
    }

    private int method01(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
