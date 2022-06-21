package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/21 11:58 下午
 * @Version 1.0
 */
public class Demo463 {

    int row;
    int col;
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        row = grid.length;
        col = grid[0].length;
        int rsp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rsp += 4;
                    if (i > 0 && grid[i - 1][j] == 1) rsp -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) rsp -= 2;
                }
            }
        }
        return rsp;
    }
}
