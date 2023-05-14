package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author milindeyu
 * @Date 2023/5/3 12:11 上午
 * @Version 1.0
 */
public class Demo1003 {

    public boolean isValid(String s) {
//        return method1(s);
//        return method2(s);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            content.append(s.charAt(i));
            if (content.length() >= 3
                    && content.substring(content.length() - 3).equals("abc")) {
                content.delete(content.length() - 3, content.length());
            }
        }
        return content.length() == 0;
    }

    private boolean method2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            while (stack.size() >= 3) {
                int size = stack.size();
                if (stack.get(size - 1) == 'c' && stack.get(size - 2) == 'b' && stack.get(size - 3) == 'a') {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean method1(String s) {
        int idx = -1;
        char[] chars = s.toCharArray();
        while (s != null && !"".equals(s)) {
            if ((idx = s.indexOf("abc")) == -1) {
                return false;
            }
            s = s.substring(0, idx) + s.substring(idx + 3);
        }
        return true;
    }
}
