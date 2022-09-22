package com.leetcode.weekly.twoweek.week86;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/9/3 11:15 下午
 * @Version 1.0
 */
public class Demo6173 {

    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length, n = mat[0].length;
        if (n == cols) return m;
        // 当前set栈元素为int数组，包含两个元素，第一个元素为当前列的下标，第二个元素值为当前列中的1的数量和
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1]) return o2[0] - o1[0];
                else return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            int oneCount = 0;
            for (int j = 0; j < m; j++) {
                if (mat[j][i] == 1) oneCount++;
            }
            queue.offer(new int[]{i, oneCount});
        }
        for (int i = 0; i < cols; i++) {
            int[] nums = queue.poll();
            for (int j = 0; j < m; j++) {
                mat[j][nums[0]] = 0;
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            boolean cover = true;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cover = false;
                    break;
                }
            }
            if (cover) res++;
        }
        return res;
    }
}
