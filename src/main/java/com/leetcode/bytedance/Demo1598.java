package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/9/9 12:48 上午
 * @Version 1.0
 */
public class Demo1598 {

    public int minOperations(String[] logs) {
        // 思路：用栈遍历存储，最后判断栈的大小
        Deque<String> stack = new ArrayDeque<>();
        for (String log : logs) {
            if ("../".equals(log)) {
                if (!stack.isEmpty()) stack.poll();
            } else if (!"./".equals(log)) stack.offer(log);
        }
        return stack.size();
    }
}
