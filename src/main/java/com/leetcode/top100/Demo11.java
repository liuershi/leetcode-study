package com.leetcode.top100;

/**
 * @Author milindeyu
 * @Date 2023/6/24 9:48 下午
 * @Version 1.0
 */
public class Demo11 {

    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            max = Math.max(max, h * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
