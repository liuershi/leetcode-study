package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/11/5 2:12 下午
 * @Version 1.0
 */
public class Demo1106 {

    public boolean parseBoolExpr(String expression) {
        char[] chars = expression.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        boolean rsp = true;
        for (char c : chars) {
            if (c == ',') continue;
            boolean and = true, or = false, not = true;
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    Character character = stack.pop();
                    and &= character == 't';
                    or |= character == 't';
                    not = !(character == 't');
                }
                stack.pop();
                char symbol = stack.pop();
                if (symbol == '&')
                    stack.push(and ? 't' : 'f');
                else if (symbol == '|')
                    stack.push(or ? 't' : 'f');
                else
                    stack.push(not ? 't' : 'f');
                rsp = stack.peek() == 't';
            } else {
                stack.push(c);
            }
        }
        return rsp;
    }
}
