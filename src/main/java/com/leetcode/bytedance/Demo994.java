package com.leetcode.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 腐烂的橘子
 *
 * @Author milindeyu
 * @Date 2022/8/12 11:18 下午
 * @Version 1.0
 */
public class Demo994 {

    /**
     * 这题无法使用深度优先遍历的方式，而是基于广度优先搜索实现
     */
    int m, n, res;
    public int orangesRotting(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        Deque<int[]> stack = new ArrayDeque<>();
        // 上下左右的移动
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 注意点一：由于是每分钟都腐烂，所以每个腐烂的橘子是可以同时向四周扩散的，故
        // 需要先查询处所有腐烂的橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    stack.offer(new int[]{i, j});
                }
            }
        }

        while (!stack.isEmpty()) {
            int size = stack.size();
            boolean infected = false;
            while (size-- > 0) {
                int[] item = stack.poll();
                for (int[] direction : directions) {
                    int row = item[0] + direction[0];
                    int col = item[1] + direction[1];
                    if (row < m && row >= 0 && col < n && col >=0 && grid[row][col] == 1) {
                        grid[row][col] = 0;
                        stack.offer(new int[]{row, col});
                        infected = true;
                    }
                }
            }
            // 注意点二：由于向四周扩散一次只要腐烂了就认为是一次，不能加该值的判断累加放在上面的循环内
            // 因为这样会导致四周的一次腐烂认为是多次，导致累加变多
            if (infected) res++;
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return res;
    }
}
