package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/10/19 9:33 下午
 * @Version 1.0
 */
public class Demo1726 {

    public int tupleSameProduct(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int val = nums[i] * nums[j];
                int count = map.getOrDefault(val, 0);
                sum += count * 8;
                map.put(val, ++count);
            }
        }
        return sum;
    }
}
