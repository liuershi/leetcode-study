package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/13 11:25 上午
 * @Version 1.0
 */
public class Demo768 {

    public int maxChunksToSorted(int[] arr) {

//        return method1(arr);

        // 方法二：基于单调栈实现
        // 时间复杂度：O(n) ; 空间复杂度：O(n)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int val : arr) {
            if (stack.isEmpty() || val >= stack.peek()) {
                stack.push(val);
            } else {
                int top = stack.pop();
                while (!stack.isEmpty() && stack.peek() > val) stack.pop();

                stack.push(top);
            }
        }
        return stack.size();
    }

    private int method1(int[] arr) {
        // 方法一：排序+哈希表
        // 思路：数组某个下标位置能排序的话，那么此时前i个下标元素的频次和排序后数组前i个下标元素的频次
        // 肯定是相同的，用hash表记录每个元素的频次
        // 时间复杂度：n*logn + n
        // 空间复杂度：n
        int res = 0;
        int[] sortArr = new int[arr.length];
        System.arraycopy(arr, 0, sortArr, 0, arr.length);
        Arrays.sort(sortArr);
        Map<Integer, Integer> map = new HashMap<>(2000);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) == 0) map.remove(arr[i]);

            map.put(sortArr[i], map.getOrDefault(sortArr[i], 0) - 1);
            if (map.get(sortArr[i]) == 0) map.remove(sortArr[i]);

            if (map.isEmpty()) res++;
        }
        return res;
    }
}
