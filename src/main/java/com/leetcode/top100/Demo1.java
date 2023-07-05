package com.leetcode.top100;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/6/24 9:11 下午
 * @Version 1.0
 */
public class Demo1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(target - nums[i])) {
                return new int[]{i, container.get(target - nums[i])};
            }
            container.put(nums[i], i);
        }
        return null;
    }
}
