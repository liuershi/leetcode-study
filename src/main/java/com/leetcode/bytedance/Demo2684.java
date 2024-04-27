package com.leetcode.bytedance;

import java.util.LinkedList;

/**
 * @Author fishball
 * @Date 2024/3/16 7:33 下午
 * @Version 1.0
 */
public class Demo2684 {

    int row, col;
    int max = 0;
    int[][] cache;
    public int maxMoves(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        cache = new int[row][col];
        LinkedList<Integer> path = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            dfs(grid, path, i, 0);
        }
        return max;
    }

    private int dfs(int[][] grid, LinkedList<Integer> path, int row, int col) {
        if (row >= this.row || row < 0 || col >= this.col || col < 0 || grid[row][col] == -1 ) {
            return 0;
        }
        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        int val = grid[row][col];
        if (path.isEmpty() || path.getLast() < val) {
            grid[row][col] = -1;
            path.addLast(val);
            max = Math.max(max, path.size() - 1);
            cache[row][col] = path.size() - 1;
            dfs(grid, path, row - 1, col + 1);
            dfs(grid, path, row, col + 1);
            dfs(grid, path, row + 1, col + 1);
            grid[row][col] = path.removeLast();
        }
        return cache[row][col];
    }
}
