package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zhangwei151
 * @date 2022/6/15 10:24
 */
public class Demo719 {

    public int smallestDistancePair(int[] nums, int k) {
        /*this.k = k;
        queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        traceBack(nums, new LinkedList<>(), 0);
        return queue.poll();*/

        Arrays.sort(nums);
        int left = 0, right = (int) 1e6;
        while (left < right) {
            int middle = left + right >> 1;
            if (check(nums, middle) >= k) right = middle;
            else left = middle;
        }

        return left;
    }

    private int check(int[] nums, int middle) {
        int len = nums.length, ans = 0;
        for (int i = 0, j = 1; i < len; i++) {
            while (j < len && nums[j] - nums[i] < middle) j++;
            ans += j - i + 1;
        }
        return ans;
    }

    /**
     * 回溯的方式会栈溢出，测试用例无法通过
     * @param nums
     * @param path
     * @param begin
     */
    int k;
    PriorityQueue<Integer> queue;
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
        int v = (int) 1e6;
        int val = v >> 1;
        System.out.println(val);
    }
}
