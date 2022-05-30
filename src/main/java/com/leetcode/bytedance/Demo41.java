package com.leetcode.bytedance;

import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/5/21 4:29 下午
 * @Version 1.0
 */
public class Demo41 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            swap(current, nums);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int current, int[] nums) {
        if (current < 1 || current > nums.length) return;
        int index = current - 1;
        if (current == nums[index]) return;

        int old = nums[index];
        nums[index] = current;
        swap(old, nums);
    }
}
