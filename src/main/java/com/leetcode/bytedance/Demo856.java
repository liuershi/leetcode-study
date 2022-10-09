package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * @Author milindeyu
 * @Date 2022/10/9 7:27 下午
 * @Version 1.0
 */
public class Demo856 {

    public int scoreOfParentheses(String s) {
        // 思路：利用栈，遍历字符，如果遍历的当前字符为（，则使用0代替，否则存在两种情况，
        // 当前字符前面字符为（，则是得到值1，否则取前面值乘以2，此时计算的值为Math.max(cur * 2, 1)
        // 再将当前值累加到栈顶元素中
        // 时间和空间复杂度均为：O(n)
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == ')') {
                // 先弹出栈顶元素
                Integer cur = stack.pop();
                // 再计算出当前累加值加到栈顶元素中
                stack.push(stack.pop() + Math.max(cur * 2, 1));
            } else stack.push(0);
        }
        return stack.isEmpty() ? 0 : stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Demo856().scoreOfParentheses("(()(()))"));
    }
}
