package com.leetcode.weekly.google.week307;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/8/21 4:20 下午
 * @Version 1.0
 */
public class Demo6155 {

    class Node {
        private long key;
        private int val;

        public Node(long key, int val) {
            this.key = key;
            this.val = val;
        }

        public long getKey() {
            return key;
        }

        public void setKey(long key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public long kSum(int[] nums, int k) {
        // 该值为最大子序列和，即所有非负数的和
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) sum += nums[i];
            else nums[i] = -nums[i]; // 负数时将其转换为正数
        }
        // 从小到大排序
        Arrays.sort(nums);
        PriorityQueue<Node> queue = new PriorityQueue<Node>((a, b) -> Long.compare(b.getKey(), a.getKey()));
        queue.offer(new Node(sum, 0));
        // 循环k - 1次
        while (--k > 0) {
            Node node = queue.poll();
            long key = node.getKey();
            int val = node.getVal();
            if (val < nums.length) {
                queue.offer(new Node(key - nums[val], val + 1));
                if (val > 0) {
                    queue.offer(new Node(key - nums[val] + nums[val - 1], val + 1));
                }
            }
        }
        return queue.peek().getKey();
    }
}
