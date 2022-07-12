package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/12 7:35 下午
 * @Version 1.0
 */
public class Demo1252 {

    public int oddCells(int m, int n, int[][] indices) {
//        return method1(m, n, indices);

        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] ints : indices) {
            rows[ints[0]]++;
            cols[ints[1]]++;
        }

        int rsp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((rows[i] + cols[j]) & 1) != 0) rsp++;
            }
        }
        return rsp;
    }

    /**
     * 直接模拟
     * @param m
     * @param n
     * @param indices
     * @return
     */
    private int method1(int m, int n, int[][] indices) {
        int[][] radix = new int[m][n];
        for (int[] nums : indices) {
            int row = nums[0];
            int col = nums[1];
            for (int i = 0; i < n; i++) {
                radix[row][i]++;
            }
            for (int i = 0; i < m; i++) {
                radix[i][col]++;
            }
        }
        int count = 0;
        for (int[] ints : radix) {
            for (int i : ints) {
                if ((i & 1) != 0) count++;
            }
        }
        return count;
    }
}
