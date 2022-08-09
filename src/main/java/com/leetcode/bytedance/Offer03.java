package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 *
 * @Author milindeyu
 * @Date 2022/7/31 10:15 下午
 * @Version 1.0
 */
public class Offer03 {

    public int findRepeatNumber(int[] nums) {
//        return method1(nums);
//        return method2(nums);
        // 由于nums中元素值范围在0～n-1，所以不存在越界
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[nums[i]]++;
            if (memo[nums[i]] == 2) return nums[i];
        }
        return nums[0];
    }

    private int method2(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (left > 0 && nums[left] == nums[left - 1]) return nums[left];
            if (right < nums.length - 1 && nums[right] == nums[right + 1]) return nums[right];
            left++;
            right--;
        }
        return nums[0];
    }

    private int method1(int[] nums) {
        Set<Integer> container = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!container.add(num)) return num;
        }
        return nums[0];
    }
}
