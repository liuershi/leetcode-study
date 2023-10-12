package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2023/10/8 9:34 下午
 * @Version 1.0
 */
public class Demo2034 {


    class StockPrice {

        Map<Integer, Integer> map;
        PriorityQueue<int[]> maxQueue, minQueue;
        int maxTime;

        public StockPrice() {
            this.map = new HashMap<>();
            this.minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            this.maxQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        }

        public void update(int timestamp, int price) {
            maxTime = Math.max(maxTime, timestamp);
            map.put(timestamp, price);
            maxQueue.offer(new int[]{price, timestamp});
            minQueue.offer(new int[]{price, timestamp});
        }

        public int current() {
            return map.get(maxTime);
        }

        public int maximum() {
            return getValueByType(maxQueue);
        }

        public int minimum() {
            return getValueByType(minQueue);
        }

        private int getValueByType(PriorityQueue<int[]> queue) {
            while (!queue.isEmpty()) {
                int[] nums = queue.peek();
                int price = nums[0], timestamp = nums[1];
                if (map.get(timestamp) == price) {
                    return price;
                }
                queue.poll();
            }
            return -1;
        }
    }


}
