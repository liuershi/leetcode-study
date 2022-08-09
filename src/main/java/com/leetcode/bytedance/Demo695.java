package com.leetcode.bytedance;

/**
 * 岛屿的最大面积
 *
 * @Author milindeyu
 * @Date 2022/7/31 9:54 下午
 * @Version 1.0
 */
public class Demo695 {

    int[][] grid;
    int m, n, rsp;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rsp = Math.max(rsp, areaSpread(i, j));
                }
            }
        }
        return rsp;
    }

    /**
     * 向四周扩散
     * @param i 扩散横坐标
     * @param j 扩散纵坐标
     */
    private int areaSpread(int i, int j) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return areaSpread(i + 1, j) +
                areaSpread(i - 1, j) +
                areaSpread(i, j + 1) +
                areaSpread(i, j - 1) + 1;
    }
}
