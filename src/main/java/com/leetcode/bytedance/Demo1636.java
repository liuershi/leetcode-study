package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangwei151
 * @date 2022/9/19 23:48
 */
public class Demo1636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        AtomicInteger index = new AtomicInteger();
        map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o2.getKey() - o1.getKey();
            return o1.getValue() - o2.getValue();
        }).forEach(entry -> {
            Arrays.fill(nums, index.get(), index.get() + entry.getValue(), entry.getKey());
            index.set(index.get() + entry.getValue());
        });
        return nums;
    }
}
