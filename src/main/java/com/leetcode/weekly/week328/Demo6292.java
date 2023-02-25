package com.leetcode.weekly.week328;

/**
 * @Author milindeyu
 * @Date 2023/1/15 10:34 上午
 * @Version 1.0
 */
public class Demo6292 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int[] query : queries) {
            for (int i = query[0]; i < query[2]; i++) {
                for (int j = query[1]; j < query[3]; j++) {
                    mat[i][j]++;
                }
            }
        }
        return mat;
    }
}
