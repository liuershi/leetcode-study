package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/7/21 11:41 下午
 * @Version 1.0
 */
public class Demo137 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}
