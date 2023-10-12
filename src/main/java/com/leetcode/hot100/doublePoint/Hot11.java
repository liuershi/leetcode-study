package com.leetcode.hot100.doublePoint;

/**
 * @Author milindeyu
 * @Date 2023/9/27 11:44 下午
 * @Version 1.0
 */
public class Hot11 {

    public int maxArea(int[] height) {
        // 思路：双指针，从数组起始和结束指针开始向中间移动，比较左右指针大小
        // 移动较小指针下标，直至双指针相遇
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            max = Math.max(max, h * (end - start));
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return max;
    }
}
