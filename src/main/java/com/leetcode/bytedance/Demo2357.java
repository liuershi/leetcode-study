package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2023/2/24 12:25 上午
 * @Version 1.0
 */
public class Demo2357 {

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int sub = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] > sub) {
                count++;
                sub += nums[i] - sub;
            }
        }
        return count;
    }
}
