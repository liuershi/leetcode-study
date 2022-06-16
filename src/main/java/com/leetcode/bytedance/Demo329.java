package com.leetcode.bytedance;

import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/6/16 11:47 下午
 * @Version 1.0
 */
public class Demo329 {

    int rsp = 0;
    int row;
    int col;

    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        out:for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int[][] cache = new int[row][col];
                if (rsp == row * col) break out;
                dfs(matrix, i, j, new LinkedList<Integer>(), cache);
            }
        }
        return rsp;
    }

    private void dfs(int[][] matrix, int row, int col, LinkedList<Integer> path, int[][] cache) {
        if (row < 0 || row == this.row || col < 0 || col == this.col || cache[row][col] == -1) return;
        int value = matrix[row][col];
        if (!path.isEmpty() && path.peekLast() >= value) return;
        path.addLast(value);
        cache[row][col] = -1;
        rsp = Math.max(rsp, path.size());
        dfs(matrix, row - 1, col, path, cache);
        dfs(matrix, row + 1, col, path, cache);
        dfs(matrix, row, col - 1, path, cache);
        dfs(matrix, row, col + 1, path, cache);
        cache[row][col] = 0;
        path.removeLast();
    }
}
