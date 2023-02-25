package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/2/14 12:04 上午
 * @Version 1.0
 */
public class Demo1124 {

    public int longestWPI(int[] hours) {
        // 思路：滑动窗口无法实现，使用前缀和
        int n = hours.length, ans = 0;
        int[] sum = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (!stack.isEmpty() && sum[i] < sum[stack.peek()]) {
                stack.push(i);
            }
        }

        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && sum[i] > sum[stack.peek()]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }
}
