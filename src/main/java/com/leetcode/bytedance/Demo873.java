package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/7/9 2:26 下午
 * @Version 1.0
 */
public class Demo873 {

    /**
     * 基于动态规划实现。
     *  时间是复杂度：O(n^2)
     *  空间复杂度：O(n^2)
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) < 3) return 0;

        int rsp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        // 该二维dp数组存储的以i、j下标的元素为最后两个节点的最大斐波那契子序列长度
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            // 注意：arr是单调递增的，以arr[j]和arr[i]为最后两个元素，需满足arr[j]*2 > arr[i]，因为
            // 如果两倍的arr[j]都小于arr[i]话，那肯定无法在j前面找到一个满足arr[k] + arr[j] = arr[i]的数k
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i] ; j--) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    // 此时说明能找到三个下标 k < j < i 且满足 arr[k] + arr[j] = arr[i] 的关系
                    // 那么以j和i为最后两个元素时，则可能刚好由k、j、i组成，或者以k、j为最后两个元素时的最大子序列再加1
                    dp[j][i] = Math.max(3, dp[k][j] + 1);
                }
                rsp = Math.max(rsp, dp[j][i]);
            }
        }
        return rsp;
    }
}
