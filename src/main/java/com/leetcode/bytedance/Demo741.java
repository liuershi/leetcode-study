package com.leetcode.bytedance;


/**
 * @Author milindeyu
 * @Date 2022/7/10 1:47 下午
 * @Version 1.0
 */
public class Demo741 {

    int N;
    int[][] grid;
    Integer[][][][] memo;
    final int[][] directions = {{1, 0}, {0, 1}};
    public int cherryPickup(int[][] grid) {
        N = grid.length;
        this.grid = grid;
        memo = new Integer[N][N][N][N];
        return Math.max(0, helper(0, 0, 0, 0));
    }

    private int helper(int i1, int j1, int i2, int j2) {
        if (i1 == N - 1 && j1 == N - 1) return grid[i1][j1];
        Integer memoVal = memo[i1][j1][i2][j2];
        if (memoVal != null) return memoVal;
        int cur;
        if (i1 == i2 && j1 == j2) cur = grid[i1][j1];
        else cur = grid[i1][j1] + grid[i2][j2];

        int rsp = Integer.MIN_VALUE;
        for (int[] direction : directions) {
            int nextI1 = i1 + direction[0];
            int nextJ1 = j1 + direction[1];
            if (nextI1 >= 0 && nextI1 < N && nextJ1 >= 0 && nextJ1 < N && grid[nextI1][nextJ1] != -1) {
                for (int[] ints : directions) {
                    int nextI2 = i2 + ints[0];
                    int nextJ2 = j2 + ints[1];
                    if (nextI2 >= 0 && nextI2 < N && nextJ2 >= 0 && nextJ2 < N && grid[nextI2][nextJ2] != -1) {
                        rsp = Math.max(rsp, cur + helper(nextI1, nextJ1, nextI2, nextJ2));
                    }
                }
            }
        }
        memo[i1][j1][i2][j2] = rsp;
        return rsp;
    }
}
