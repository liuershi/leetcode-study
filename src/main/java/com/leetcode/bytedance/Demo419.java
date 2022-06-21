package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/21 11:31 下午
 * @Version 1.0
 */
public class Demo419 {

    int row;
    int col;
    int rsp;

    public int countBattleships(char[][] board) {
        this.row = board.length;
        this.col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '0') continue;
                if (board[i][j] == 'X') {
                    rsp++;
                    dfs(i, j, board);
                }
                board[i][j] = '0';
            }
        }
        return rsp;
    }

    private void dfs(int row, int col, char[][] board) {
        if (row < 0 || row == this.row || col < 0 || col == this.col
                || board[row][col] != 'X') return;
        board[row][col] = '0';
        dfs(row + 1, col, board);
        dfs(row, col + 1, board);
    }

    /**
     * 方式二
     * @param board
     * @return
     */
    public int countBattleshipsTwo(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int rsp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    // 由于只能垂直或水平方向建造
                    board[i][j] = '.';
                    for (int k = j + 1; k < col; k++) {
                        if (board[i][k] == 'X') board[i][k] = '.';
                        else break;
                    }
                    for (int k = i + 1; k < row; k++) {
                        if (board[k][j] == 'X') board[k][j] = '.';
                        else break;
                    }
                    rsp++;
                }
            }
        }
        return rsp;
    }
}
