package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/6/21 10:19 下午
 * @Version 1.0
 */
public class Demo417 {

    int row;
    int col;
    int[][] heights;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.row = heights.length;
        this.col = heights[0].length;
        this.heights = heights;
        // 声明可以到太平洋和大西洋的节点
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        // 从上下左右四个边开始扩散
        // 左边界
        for (int i = 0; i < row; i++) {
            dfs(i, 0, pacific);
        }
        // 上边界
        for (int i = 1; i < col; i++) {
            dfs(0, i, pacific);
        }
        // 右边界
        for (int i = 0; i < row; i++) {
            dfs(i, col - 1, atlantic);
        }
        // 下边界
        for (int i = 0; i < col - 1; i++) {
            dfs(row - 1, i, atlantic);
        }
        // 再次遍历判断节点都可达时为结果
        List<List<Integer>> rsp = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    rsp.add(Arrays.asList(i, j));
                }
            }
        }
        return rsp;
    }

    private void dfs(int row, int col, boolean[][] feasibility) {
        if (feasibility[row][col]) return;
        feasibility[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0], newCol = col + direction[1];
            // 需要扩散的节点未越界且是非递减的
            if (newRow >= 0 && newRow < this.row
                    && newCol >= 0 && newCol < this.col
                    && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, feasibility);
            }
        }
    }
}
