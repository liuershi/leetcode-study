package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2024/1/10 9:20 下午
 * @Version 1.0
 */
public class Demo2696 {

    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'B' || c == 'D') {
                if (!stack.isEmpty() && stack.peek() == c - 1) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
