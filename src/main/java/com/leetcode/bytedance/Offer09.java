package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用两个栈实现队列
 *
 * @Author milindeyu
 * @Date 2022/7/31 10:48 下午
 * @Version 1.0
 */
public class Offer09 {

    class CQueue {

        Deque<Integer> stack;

        public CQueue() {
            stack = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if (stack.isEmpty()) return -1;
            return stack.pollLast();
        }
    }
}
