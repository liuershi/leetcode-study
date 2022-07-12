package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/12 11:27 下午
 * @Version 1.0
 */
public class Demo219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 存储数组中元素值和其下标的映射
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val) && i - map.get(val) <= k) return true;
            map.put(val, i);
        }
        return false;
    }
}
