package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/8/24 10:49 下午
 * @Version 1.0
 */
public class Demo503 {

    public int[] nextGreaterElements(int[] nums) {
        // 思路：基于单调栈，和OfferII038相似，不过本题中要求循环查询
        // 可将两个 nums 数组合并遍历，那么若存在某个数的下一个最大值在
        // 其左边时，当遍历数组下标到 n + x 位置时，则通过取余获取其最大值的下标
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        // 用栈记录每个元素的下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2 /*此时为两倍数组长度*/; i++) {
            // 下面获取下标都是取余
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek() % n]) {
                res[stack.peek() % n] = nums[i % n];
                stack.poll();// 出栈
            }
            stack.push(i % n);
        }
        return res;
    }
}
