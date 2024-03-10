package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2024/1/31 10:50 下午
 * @Version 1.0
 */
public class Demo2670 {

    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            leftMap.put(val, 1);
            Integer cnt = rightMap.get(val);
            if (cnt == 1) {
                rightMap.remove(val);
            } else {
                rightMap.put(val, --cnt);
            }
            nums[i] = leftMap.size() - rightMap.size();
        }

        return nums;
    }
}
