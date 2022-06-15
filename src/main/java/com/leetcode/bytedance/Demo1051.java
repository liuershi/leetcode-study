package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @author zhangwei151
 * @date 2022/6/13 16:35
 */
public class Demo1051 {

    public int heightChecker(int[] heights) {
        return method01(heights);
        // 基于快排来实现
        // todo 暂未实现
//        int len;
//        if (heights == null || (len = heights.length) < 2) return 0;
//        quickSort(heights, 0, len - 1);
    }

    private void quickSort(int[] heights, int start, int end) {
        if (start < end) {
            int key = heights[start];
            int left = start, right = end;
            while (left < right) {
                while (heights[right] >= key) right--;
                if (left < right) {
                    heights[left] = heights[right];
                    left++;
                }
            }
        }
    }

    /**
     * 基于复制排序实现，时间和空间复杂度都是 O（n）
     * @param heights
     * @return
     */
    private int method01(int[] heights) {
        int len;
        if (heights == null || (len = heights.length) < 2) return 0;
        int[] copy = Arrays.copyOf(heights, len);
        Arrays.sort(copy);
        int rsp = 0;
        for (int i = 0; i < len; i++) {
            if (heights[i] != copy[i]) rsp++;
        }
        return rsp;
    }
}
