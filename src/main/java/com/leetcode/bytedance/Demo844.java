package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangwei151
 * @date 2022/9/24 20:32
 */
public class Demo844 {

    public boolean backspaceCompare(String s, String t) {
        // 思路：基于栈实现
//        return method1(s, t);

        // 思路二：双指针，时间复杂度O(N)，空间复杂度O(1)
        int sr = s.length() - 1, tr = t.length() - 1;
        // 标识需要跳过的字符串
        int skipS = 0, skipT = 0;
        while (sr >= 0 || tr >= 0) {
            while (sr >= 0) {
                if (s.charAt(sr) == '#') {
                    skipS++;
                    sr--;
                } else if (skipS > 0) {
                    skipS--;
                    sr--;
                } else {
                    break;
                }
            }
            while (tr >= 0) {
                if (t.charAt(tr) == '#') {
                    skipT++;
                    tr--;
                } else if (skipT > 0) {
                    skipT--;
                    tr--;
                } else {
                    break;
                }
            }
            if (sr >= 0 && tr >= 0) {
                if (s.charAt(sr) != t.charAt(tr)) return false;
            } else {
                if (sr >= 0 || tr >= 0) return false;
            }
            sr--;
            tr--;
        }
        return true;
    }

    private boolean method1(String s, String t) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == '#')
                stack.pop();
            else if (c != '#')stack.push(c);
        }
        Deque<Character> stackTwo = new ArrayDeque<>();
        for (char c : t.toCharArray()) {
            if (!stackTwo.isEmpty() && c == '#')
                stackTwo.pop();
            else if (c != '#')stackTwo.push(c);
        }
        if (stack.size() != stackTwo.size()) return false;
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(stackTwo.pop())) return false;
        }
        return true;
    }
}
