package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/16 12:03 上午
 * @Version 1.0
 */
public class Demo532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int rsp = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (map.get(nums[i]) != null && map.get(nums[i]) == nums[j]) continue;
                if (nums[j] - nums[i] > k) break;
                if (Math.abs(nums[i] - nums[j]) == k) {
                    rsp++;
                    map.put(nums[i], nums[j]);
                };
            }
        }
        return rsp;
    }
}
