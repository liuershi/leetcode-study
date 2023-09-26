package com.leetcode.hot100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/9/26 9:57 下午
 * @Version 1.0
 */
public class Hot1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) {
                return new int[]{idx, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
