package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author milindeyu
 * @Date 2022/7/25 10:56 下午
 * @Version 1.0
 */
public class Demo414 {

    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        for (int num : nums) {
            if (queue.contains(num)) continue;
            queue.add(num);
            if (queue.size() > 3) queue.poll();
        }
        int rsp = queue.peek();
        if (queue.size() < 3) {
            while (!queue.isEmpty()) rsp = queue.poll();
        }
        return rsp;
    }

    public static void main(String[] args) {
            System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
    }
}
