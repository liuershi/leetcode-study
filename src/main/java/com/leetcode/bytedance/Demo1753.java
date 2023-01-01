package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/12/21 12:07 上午
 * @Version 1.0
 */
public class Demo1753 {

    public int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2])
            return nums[0] + nums[1];
        return maximumScore(nums[0] - 1, nums[1] - 1, nums[2]) + 1;
    }
}
