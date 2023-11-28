package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2023/10/18 6:35 下午
 * @Version 1.0
 */
public class Demo2530 {

    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.offer(num);
        }
        while (k-- > 0 && !queue.isEmpty()) {
            Integer val = queue.poll();
            sum += val;

            int next = val / 3;
            if (val % 3 != 0) {
                next++;
            }
            if (next != 0) {
                queue.offer(next);
            }
        }

        return sum;
    }
}
