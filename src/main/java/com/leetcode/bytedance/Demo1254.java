package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/18 12:07 上午
 * @Version 1.0
 */
public class Demo1254 {

    int row, col, ans;
    public int closedIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && diffusion(grid, i, j)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean diffusion(int[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }
        if (grid[i][j] != 0) {
            return true;
        }
        grid[i][j] = -1;

        boolean b1 = diffusion(grid, i + 1, j);
        boolean b2 = diffusion(grid, i - 1, j);
        boolean b3 = diffusion(grid, i, j + 1);
        boolean b4 = diffusion(grid, i, j - 1);
        return b1 && b2 && b3 && b4;
    }
}
