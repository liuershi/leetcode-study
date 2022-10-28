package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/10/28 9:07 下午
 * @Version 1.0
 */
public class Demo907 {

    public int sumSubarrayMins(int[] arr) {
//        return method1(arr);

        // 思路二：参照 https://leetcode.cn/problems/sum-of-subarray-minimums/solution/xiao-bai-lang-dong-hua-xiang-jie-bao-zhe-489q/
        // 边界处理
        int len;
        if (arr == null || (len = arr.length) == 0) return 0;
        // 每个元素的左边界和右边界
        int[] left = new int[len];
        int[] right = new int[len];

        int divisor = (int) 1e9 + 7;
        Deque<Integer> stack = new ArrayDeque<>();
        // 处理每个元素的左边界
        for (int i = 0; i < len; i++) {
            // 找到第一个小于等于当前元素的边界
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();

            int val = -1;
            if (!stack.isEmpty())
                val = stack.peek();
            left[i] = val;
            stack.push(i);
        }
        stack.clear();
        // 处理每个元素的右边界
        for (int i = len - 1; i >= 0; i--) {
            // 找到第一个小于当前元素的节点
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            int val = len;
            if (!stack.isEmpty())
                val = stack.peek();
            right[i] = val;
            stack.push(i);
        }

        long rsp = 0;
        for (int i = 0; i < len; i++) {
            rsp = (rsp + (long) (i - left[i]) * (right[i] - i) * arr[i]) % divisor;
        }
        return (int) rsp;
    }

    private int method1(int[] arr) {
        // 思路：双层for循环暴力
        // 时间复杂度：O(n2)
        // 空间复杂度：O(1)
        // 问题：数据范围较大，会超时
        int len;
        if (arr == null || (len = arr.length) == 0)
            return 0;

        int divisor = (int) 1e9 + 7;
        int rsp = 0;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, arr[j]);
                rsp += min;
                rsp %= divisor;
            }
        }
        return rsp;
    }
}
