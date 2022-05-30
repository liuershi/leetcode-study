package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @Author milindeyu
 * @Date 2022/3/19 4:26 下午
 * @Version 1.0
 */
public class Demo1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val != null) {
                return new int[]{val, i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }
}
