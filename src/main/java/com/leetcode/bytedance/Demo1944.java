package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author milindeyu
 * @Date 2024/1/5 9:16 下午
 * @Version 1.0
 */
public class Demo1944 {

    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                ans[i]++;
            }
            if (!stack.isEmpty()) {
                ans[i]++;
            }
            stack.push(heights[i]);
        }

        return ans;
    }
}
