package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/10/9 10:26 下午
 * @Version 1.0
 */
public class Demo628 {

    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3],
                nums[0] * nums[1] * nums[len - 1]);
    }
}
