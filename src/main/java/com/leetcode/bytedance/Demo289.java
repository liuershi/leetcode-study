package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/9/2 11:14 下午
 * @Version 1.0
 */
public class Demo289 {

    int row, col;
    public void gameOfLife(int[][] board) {
        // 思路：遍历面板，记录需要变更的格子的下标
        Set<int[]> changeSet = new HashSet<>();
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                process(i, j, board, changeSet);
            }
        }

        for (int[] coordinate : changeSet) {
            board[coordinate[0]][coordinate[1]] = coordinate[2];
        }
    }

    /**
     * 当前格子是否需要变更
     * @param row 行坐标
     * @param col 列坐标
     * @param board 面板
     * @param changeSet 变更坐标集
     */
    private void process(int row, int col, int[][] board, Set<int[]> changeSet) {
        int count = livingCellCount(row, col, board);
        if (board[row][col] == 1 && (count < 2 || count > 3)) {
            // 活细胞
            changeSet.add(new int[]{row, col, 0});
        }
        if (board[row][col] == 0 && count == 3){
            // 死细胞
            changeSet.add(new int[]{row, col, 1});
        }
    }

    /**
     * 统计当前细胞周围活细胞数量
     * @param row 行坐标
     * @param col 列坐标
     * @return 活细胞数量
     */
    private int livingCellCount(int row, int col, int[][] board) {
        int count = 0;
        if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 1) count++;
        if (row - 1 >= 0 && board[row - 1][col] == 1) count++;
        if (row - 1 >= 0 && col + 1 < this.col && board[row - 1][col + 1] == 1) count++;
        if (col - 1 >= 0 && board[row][col - 1] == 1) count++;
        if (col + 1 < this.col && board[row][col + 1] == 1) count++;
        if (row + 1 < this.row && col + 1 < this.col && board[row + 1][col + 1] == 1) count++;
        if (row + 1 < this.row && board[row + 1][col] == 1) count++;
        if (row + 1 < this.row && col - 1 >= 0 && board[row + 1][col - 1] == 1) count++;
        return count;
    }
}
