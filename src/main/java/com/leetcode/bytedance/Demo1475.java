package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/9/1 12:13 上午
 * @Version 1.0
 */
public class Demo1475 {

    public int[] finalPrices(int[] prices) {
//        return method1(prices);
        // 方式二：单调栈
        // 时间复杂度：O(n) , 空间复杂度：O(n)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                Integer index = stack.poll();
                prices[index] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }

    private int[] method1(int[] prices) {
        // 方法一：暴力
        // 时间复杂度：O(n2) 空间复杂度：O(1)
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
