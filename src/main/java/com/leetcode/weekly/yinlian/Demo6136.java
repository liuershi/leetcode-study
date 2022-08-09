package com.leetcode.weekly.yinlian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/8/7 10:32 上午
 * @Version 1.0
 */
public class Demo6136 {

    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> container = new HashSet<>(nums.length);
        for (int num : nums) {
            container.add(num);
        }

        int rsp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + diff > nums[nums.length - 1]) break;
            int valJ = nums[i] + diff;
            if (container.contains(valJ) && container.contains(valJ + diff)) rsp++;
        }
        return rsp;
    }
}
