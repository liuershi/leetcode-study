package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/5/7 3:45 下午
 * @Version 1.0
 */
public class Demo1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : time) {
            val %= 60;
            if (map.containsKey(60 - val)) {
                count += map.get(60 - val);
            }
            if (val == 0 && map.containsKey(val)) {
                count += map.get(val);
            }
            map.put(val, map.getOrDefault(val, 0) + 1);

        }
        return count;
    }
}
