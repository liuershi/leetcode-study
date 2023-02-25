package com.leetcode.weekly.week328;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/1/15 10:40 上午
 * @Version 1.0
 */
public class Demo6293 {

    public long countGood(int[] nums, int k) {
        // 滑动窗口
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int left = 0, pairs = 0;
        for (int val : nums) {
            pairs += map.getOrDefault(val, 0);
            map.merge(val, 1, Integer::sum);
            while (pairs - map.get(nums[left]) + 1 >= k) {
                pairs -= map.merge(nums[left++], -1, Integer::sum);
            }
            if (pairs >= k) {
                ans += left + 1;
            }
        }
        return ans;
    }
}
