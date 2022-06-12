package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/12 7:34 下午
 * @Version 1.0
 */
public class Demo130 {

    List<int[]> path = new ArrayList<>();
    boolean isValid;

    int height;
    int width;

    public void solve(char[][] board) {
        height = board.length;
        width = board[0].length;
        if (height == 1 || width == 1) return;
        // 保存处理过的点位信息
        boolean[][] process = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                isValid = true;
                path.clear();
                if (board[i][j] == 'X' || process[i][j]) {
                    process[i][j] = true;
                    continue;
                }
                dfs(board, i, j, process);
                if (isValid) {
                    // 若有效则遍历处理将'O'转换为'X'
                    path.forEach(item -> board[item[0]][item[1]] = 'X');
                }
            }
        }
    }

    private void dfs(char[][] board, int height, int width, boolean[][] process) {
        if (height < 0 || height >= this.height || width < 0 || width >= this.width || process[height][width] || board[height][width] == 'X') return;
        process[height][width] = true;
        path.add(new int[]{height, width});
        if (height == 0 || height == this.height - 1 || width == 0 || width == this.width - 1) isValid = false;
        // 向四周扩散
        dfs(board, height - 1, width, process);
        dfs(board, height + 1, width, process);
        dfs(board, height, width - 1, process);
        dfs(board, height, width + 1, process);
    }




    // ====================== 方法二：使用遍历边界上的O来实现 ========================
    public void solveTwo(char[][] board) {
        height = board.length;
        width = board[0].length;
        if (height == 1 || width == 1) return;
        boolean[][] process = new boolean[height][width];
        for (int i = 0; i < width; i++) {
            dfsTwo(board, 0, i, process);
            dfsTwo(board, height - 1, i, process);
        }
        for (int i = 0; i < height; i++) {
            dfsTwo(board, i, 0, process);
            dfsTwo(board, i, width - 1, process);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!process[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfsTwo(char[][] board, int height, int width, boolean[][] process) {
        if (height < 0 || height >= this.height || width < 0 || width >= this.width || process[height][width]) return;
        // 标记当前节点为已处理
        process[height][width] = true;
        // 若不为O则直接返回
        if (board[height][width] == 'X') return;
        dfsTwo(board, height - 1, width, process);
        dfsTwo(board, height + 1, width, process);
        dfsTwo(board, height, width - 1, process);
        dfsTwo(board, height, width + 1, process);
    }
}
