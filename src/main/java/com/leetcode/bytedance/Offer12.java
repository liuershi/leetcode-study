package com.leetcode.bytedance;

import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * @Author milindeyu
 * @Date 2022/9/4 10:52 下午
 * @Version 1.0
 */
public class Offer12 {

    boolean res;
    int m, n;
    char[][] board;
    String word;
    boolean[][] visitor;
    public boolean exist(char[][] board, String word) {
        // 思路：回溯，遍历所有可能情况判断是否满足
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        this.visitor = new boolean[m][n];
        if (m * n < word.length()) return false;
        out:for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                traceBack(i, j, 0);
                if (res) break out;
            }
        }
        return res;
    }

    private void traceBack(int row, int col, int len) {
        if (len == word.length()) {
            res = true;
            return;
        }
        if (row < 0 || row == m || col < 0 || col == n || visitor[row][col] || board[row][col] != word.charAt(len)) return;
        visitor[row][col] = true;
        traceBack(row - 1, col, len + 1);
        traceBack(row + 1, col, len + 1);
        traceBack(row, col + 1, len + 1);
        traceBack(row, col - 1, len + 1);
        visitor[row][col] = false;
    }
}
