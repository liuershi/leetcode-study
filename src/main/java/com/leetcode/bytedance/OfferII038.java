package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/8/24 11:08 下午
 * @Version 1.0
 */
public class OfferII038 {

    public int[] dailyTemperatures(int[] temperatures) {
        // 思路：单调栈实现，每次判断当前栈是否为空且当前遍历的元素是否大于栈顶元素，若大于
        // 则认为当前元素是满足条件的，用当前下标减去栈中存储的下标，此时栈顶元素出栈，下个
        // 元素作为栈顶元素，再次判断，循环往复
        int n = temperatures.length;
        int[] res = new int[n];
        // 存储的元素下标而不是值，这样才能正确将值填充到res中
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.poll();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
