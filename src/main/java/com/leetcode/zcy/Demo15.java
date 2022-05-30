package com.leetcode.zcy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *
 * 实现逆序一个栈内元素，不使用额外空间，且只能使用递归
 *
 * @Author milindeyu
 * @Date 2022/4/19 11:14 下午
 * @Version 1.0
 */
public class Demo15 {

    /**
     * 该方法实现移除栈底元素并返回
     * @param stack
     * @return
     */
    public int func(Stack<Integer> stack) {
        Integer num = stack.pop();
        if (stack.isEmpty()) {
            return num;
        } else {
            int last = func(stack);
            stack.push(num);
            return last;
        }
    }

    /**
     * 反转栈
     * @param stack
     */
    public void reversal(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int num = func(stack);
        reversal(stack);
        stack.push(num);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        Demo15 demo15 = new Demo15();

        System.out.println(stack);
        demo15.reversal(stack);
        System.out.println(stack);
    }
}
