package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/31 5:15 下午
 * @Version 1.0
 */
public class Demo739 {

    public int[] dailyTemperatures(int[] temperatures) {
//        return method1(temperatures);

        // 基于单调栈，时间复杂度为O(n)
        // 记录的是元素的下标
        Deque<Integer> stack = new ArrayDeque<>(temperatures.length);
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }


    /**
     * 暴力破解：时间复杂度O(n^2)
     * @param temperatures
     * @return
     */
    private int[] method1(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            answer[i] = searchNextAnswer(temperatures, i);
        }
        return answer;
    }

    private int searchNextAnswer(int[] temperatures, int i) {
        int val = temperatures[i];
        for (int j = i + 1; j < temperatures.length; j++) {
            if (temperatures[j] > val) return j - i;
        }
        return 0;
    }
}
