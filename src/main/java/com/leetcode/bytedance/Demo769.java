package com.leetcode.bytedance;

/**
 * 最多能完成排序的块
 * 相同题目：最多能完成排序的块II {@link https://leetcode.cn/problems/max-chunks-to-make-sorted/}
 *
 * @Author milindeyu
 * @Date 2022/8/13 11:54 上午
 * @Version 1.0
 */
public class Demo769 {


    public int maxChunksToSorted(int[] arr) {
        // 说明：arr的范围在0～n-1，而且arr中不存在重复数

        // 思路：根据说明可知，如果i位置能分成块，那么前i个元素中最大的值一定是等于i的，否则
        // 就存在较小的值在右边
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) res++;
        }
        return res;
    }
}
