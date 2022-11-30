package com.leetcode.bytedance;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author milindeyu
 * @Date 2022/11/30 10:38 下午
 * @Version 1.0
 */
public class Demo895 {

    static class FreqStack {

        /**
         * 思路：优先级队列
         */
        // 记录谁离栈顶近
        int time;
        Map<Integer, Integer> map;
        // 记录每个元素的信息，包括值、存在的次数、时间戳time
        PriorityQueue<int[]> queue;

        public FreqStack() {
            this.time = 0;
            this.map = new HashMap<>();
            this.queue = new PriorityQueue<int[]>((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    // 当存在次数相同时比较时间戳
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            });
        }

        public void push(int val) {
            int cnt = map.getOrDefault(val, 0) + 1;
            map.put(val, cnt);
            queue.offer(new int[]{val, cnt, time++});
        }

        public int pop() {
            int[] node = queue.poll();

            map.put(node[0], node[1] - 1);

            return node[0];
        }
    }

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
