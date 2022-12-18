package com.leetcode.weekly.week323;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/12/11 10:38 上午
 * @Version 1.0
 */
public class Demo6258 {

    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Double, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey((double)nums[i]))
                continue;
            if (map.containsKey(Math.pow(nums[i], 0.5))) {
                map.put((double) nums[i], map.get(Math.pow(nums[i], 0.5)) + 1);
                res = Math.max(res, map.get((double)nums[i]));
            } else {
                map.put((double) nums[i], 0);
            }
        }

        return res == 0 ? -1 : res + 1;
    }
}
