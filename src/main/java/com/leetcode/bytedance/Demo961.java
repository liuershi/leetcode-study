package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/5/21 11:04 上午
 * @Version 1.0
 */
public class Demo961 {

    public int repeatedNTimes(int[] nums) {
//        return method1(nums);

        int rsp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                return nums[i];
            }
            if (i > 1 && nums[i] == nums[i - 2]) {
                return nums[i];
            }
        }

        return rsp;
    }

    private int method1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
