package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author milindeyu
 * @Date 2022/5/8 9:58 下午
 * @Version 1.0
 */
public class Demo84 {

    public int largestRectangleArea(int[] heights) {
//        return method1(heights);

        // 方式二：基于单调栈的方式
        int rsp = 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int val = newHeights[stack.pop()];
                rsp = Math.max(rsp, (i - stack.peek() - 1) * val);
            }
            stack.push(i);
        }

        return rsp;
    }

    private int method1(int[] heights) {
        // 方式一：暴力解（固定高度，底部向两边扩散）
        int rsp = 0;
        for (int i = 0; i < heights.length; i++) {

            int val = heights[i];

            int left = 0;
            int right = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= val) {
                    left++;
                    continue;
                }
                break;
            }

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= val) {
                    right++;
                    continue;
                }
                break;
            }

            rsp = Math.max(rsp, (right + left + 1) * val);
        }

        return rsp;
    }
}
