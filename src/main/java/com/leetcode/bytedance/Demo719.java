package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zhangwei151
 * @date 2022/6/15 10:24
 */
public class Demo719 {

    PriorityQueue<Integer> queue;


    public int smallestDistancePair(int[] nums, int k) {
        /*this.k = k;
        queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        traceBack(nums, new LinkedList<>(), 0);
        return queue.poll();*/
        int len = nums.length;
        queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        int row = len, col = len;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                int val = Math.abs(nums[i] - nums[j]);
                queue.offer(val);
                if (queue.size() > k) queue.poll();
            }
        }
        return queue.poll();
    }

    /**
     * 回溯的方式会栈溢出，测试用例无法通过
     * @param nums
     * @param path
     * @param begin
     */
    int k;
    private void traceBack(int[] nums, LinkedList<Integer> path, int begin) {
        if (path.size() == 2) {
            queue.add(Math.abs(path.get(0) - path.get(1)));
            if (queue.size() > k) queue.poll();
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            path.addLast(nums[i]);
            traceBack(nums, path, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,11,0,8};
        Demo719 demo719 = new Demo719();
        System.out.println(demo719.smallestDistancePair(nums, 8));
        PriorityQueue<Integer> queue = new PriorityQueue<>(25000000);
    }
}
