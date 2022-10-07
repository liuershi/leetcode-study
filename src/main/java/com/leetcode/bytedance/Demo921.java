package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/10/7 9:51 下午
 * @Version 1.0
 */
public class Demo921 {

    public int minAddToMakeValid(String s) {
        int len = 0;
        if (s == null || (len = s.length()) == 0) return len;

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else if ((c == ')' && stack.peek() == '(')) stack.pop();
            else stack.push(c);
        }
        return stack.size();
    }
}
