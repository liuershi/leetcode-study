package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/8/31 11:00 下午
 * @Version 1.0
 */
public class Demo946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n;
        if (pushed == null || (n = pushed.length) < 1) return true;

        Deque<Integer> stack = new ArrayDeque<>(n);
        int index = 0;
        for (int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                index++;
                stack.poll();
            }
        }
        return stack.isEmpty();
    }
}
