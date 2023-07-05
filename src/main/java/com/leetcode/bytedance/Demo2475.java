package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/6/13 7:08 下午
 * @Version 1.0
 */
public class Demo2475 {

    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int ans = 0, n = nums.length, t = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += t * entry.getValue() * (n - entry.getValue() - t);
            t += entry.getValue();
        }

        return ans;
    }
}
