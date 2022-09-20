package com.leetcode.bytedance;

import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/9/2 11:52 下午
 * @Version 1.0
 */
public class Demo1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int val = Math.abs(queue.poll() - queue.poll());
            if (val != 0) queue.offer(val);
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
