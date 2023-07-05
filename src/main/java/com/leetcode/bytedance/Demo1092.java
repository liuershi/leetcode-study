package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @Author milindeyu
 * @Date 2023/5/26 10:20 下午
 * @Version 1.0
 */

public class Demo1092 {

    /**
     * dfs（深度优先遍历）：时间复杂度过高，会超时
     */
    /*int grow, gcol;
    int min = Integer.MAX_VALUE;
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.gcol = grid.length;
        this.grow = grid[0].length;
        dfs(grid, 0, 0, 1);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(int[][] grid, int row, int col, int count) {
        int temp;
        if (col < 0 || col >= gcol || row < 0 || row >= grow || (temp = grid[row][col]) == -1 || temp == 1) {
            return;
        }
        if (col == gcol - 1 && row == grow - 1) {
            min = Math.min(min, count);
            return;
        }

        grid[row][col] = -1;
        dfs(grid, row - 1, col - 1, count + 1);
        dfs(grid, row - 1, col, count + 1);
        dfs(grid, row - 1, col + 1, count + 1);
        dfs(grid, row, col - 1, count + 1);
        dfs(grid, row, col + 1, count + 1);
        dfs(grid, row + 1, col - 1, count + 1);
        dfs(grid, row + 1, col, count + 1);
        dfs(grid, row + 1, col + 1, count + 1);
        grid[row][col] = temp;
    }*/


    /**
     * bfs（宽度优先遍历）
     *
     *
     * 在二维矩阵中搜索，什么时候用BFS，什么时候用DFS？
     * 1.如果只是要找到某一个结果是否存在，那么DFS会更高效。因为DFS会首先把一种可能的情况尝试到底，才会回溯去尝试下一种情况，只要找到一种情况，就可以返回了。但是BFS必须所有可能的情况同时尝试，在找到一种满足条件的结果的同时，也尝试了很多不必要的路径；
     * 2.如果是要找所有可能结果中最短的，那么BFS会更高效。因为DFS是一种一种的尝试，在把所有可能情况尝试完之前，无法确定哪个是最短，所以DFS必须把所有情况都找一遍，才能确定最终答案（DFS的优化就是剪枝，不剪枝很容易超时）。而BFS从一开始就是尝试所有情况，所以只要找到第一个达到的那个点，那就是最短的路径，可以直接返回了，其他情况都可以省略了，所以这种情况下，BFS更高效。
     *
     *
     * 本题说明：
     * BFS找到就是最短路径，因为它是相当于逐层遍历完，没有找到终点，就再多走一步。
     * 每次在队列中循环一次对应着多走一步，所以第一次加入的是起点，第二次入队的是
     * 离起点距离为1的所有通路坐标，第三次入队的是离起点距离为2 的所有坐标，以此
     * 类推，所以只要发现终点在队列中了，那个路径长度就是最短的。因为你不可能绕过
     * 离起点距离3的格子先找到距离为4的，这就是广度优先的特点。
     *
     *
     * * * * * *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (grid[0][0] == 1) {
            return -1;
        }
        if (row == 1 && col == 1) {
            return 1;
        }

        int count = 1;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offer(grid[0]);
        boolean[][] visitor = new boolean[row][col];

        int[][] directs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                int[] point = stack.pop();
                int i = point[0], j = point[1];
                for (int[] direct : directs) {
                    int newi = i + direct[0];
                    int newj = j + direct[1];
                    if (newi >= 0 && newi < row && newj >= 0 && newj < col && !visitor[newi][newj] && grid[newi][newj] == 0) {
                        if (newi == row - 1 && newj == col - 1) {
                            return count + 1;
                        }
                        stack.offer(new int[]{newi, newj});
                        visitor[newi][newj] = true;
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
