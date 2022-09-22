package com.leetcode.weekly.nio.week300;

import java.util.Arrays;

/**
 *
 * https://leetcode.cn/contest/weekly-contest-300/problems/number-of-increasing-paths-in-a-grid/
 *
 * @Author milindeyu
 * @Date 2022/8/8 11:48 下午
 * @Version 1.0
 */
public class Demo2328 {

    int m, n;
    int sum;
    int[][] memo;
    int[][] directions = {{0 , 1}, {1, 0}, {0, -1}, {-1, 0}};
    int divisor = (int) (1e9 + 7);
    public int countPaths(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += helper(i, j, grid, 0);
                sum %= divisor;
            }
        }
        return sum;
    }

    private int helper(int m, int n, int[][] grid, int prev) {
        if (m >= this.m || m < 0 || n >= this.n || n < 0 || grid[m][n] <= prev) return 0;
        if (memo[m][n] != -1) return memo[m][n];
        prev = grid[m][n];
        memo[m][n] = helper(m + 1, n, grid, prev)
                + helper(m - 1, n, grid, prev)
                + helper(m, n + 1, grid, prev)
                + helper(m, n - 1, grid, prev)
                + 1;
        // todo 日了狗
        // 妈的，这里也可能越界，要先取余。。。。。。
        memo[m][n] %= divisor;
        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println(367051581 / 89738875);
    }
}
