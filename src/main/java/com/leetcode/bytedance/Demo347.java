package com.leetcode.bytedance;

import java.util.*;

/**
 * 前k个高频元素
 *
 * @Author milindeyu
 * @Date 2022/7/30 4:55 下午
 * @Version 1.0
 */
public class Demo347 {

    public int[] topKFrequent(int[] nums, int k) {
        // 基于优先队列实现
        Map<Integer, Integer> container = new HashMap<>(nums.length);
        for (int num : nums) {
            container.put(num, container.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(container.size(), (o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(container.entrySet());
        int[] rsp = new int[k];
        for (int i = 0; i < k; i++) {
            rsp[i] = queue.poll().getKey();
        }
        return rsp;
    }
}
