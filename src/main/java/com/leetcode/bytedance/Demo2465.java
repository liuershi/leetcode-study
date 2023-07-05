package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2023/6/4 6:34 下午
 * @Version 1.0
 */
public class Demo2465 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        Set<Double> set = new HashSet<>();
        while (left < right) {
            set.add((double) (nums[left++] + nums[right--]) / 2);
        }
        return set.size();
    }
}
