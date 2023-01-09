package com.leetcode.weekly.week327;

import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2023/1/8 10:35 上午
 * @Version 1.0
 */
public class Demo6285 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.offer(num);
        }
        long sum = 0;
        while (k-- > 0) {
            Integer max = queue.poll();
            sum += max;
            queue.offer((int) Math.ceil((double)max / 3));
        }
        return sum;
    }
}
