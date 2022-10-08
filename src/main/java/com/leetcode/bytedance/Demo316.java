package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/10/7 11:35 下午
 * @Version 1.0
 */
public class Demo316 {

    public String removeDuplicateLetters(String s) {
        // 思路：使用单调栈，若当前字符比栈顶字符小，且当前字符后有栈顶字符，则弹出栈顶元素
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.contains(chars[i])) continue;
            while (!stack.isEmpty() && stack.peek() > chars[i] && s.indexOf(stack.peek(), i + 1) > 0) {
                stack.pop();
            }
            stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.reverse().toString();
    }
}
