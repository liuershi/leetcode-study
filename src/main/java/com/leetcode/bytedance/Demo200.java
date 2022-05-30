package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/3/19 6:38 下午
 * @Version 1.0
 */
public class Demo200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (!inArea(grid, x, y) || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = 2;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }

    private boolean inArea(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
