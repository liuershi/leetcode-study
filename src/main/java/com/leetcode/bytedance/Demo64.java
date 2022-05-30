package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/5/5 10:43 下午
 * @Version 1.0
 */
public class Demo64 {

    int rsp = Integer.MAX_VALUE;
    int width;
    int height;

    public int minPathSum(int[][] grid) {
        // 方法一
        /*width  = grid[0].length;
        height = grid.length;
        int[][] cache = new int[height][width];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        process(grid, 0, 0, 0, cache);
        return rsp;*/


        //方法二：动态规划
        int x = grid.length;
        int y = grid[0].length;

        int[][] matrix = new int[x + 1][y + 1];

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (i == 1)
                    matrix[i][j] = matrix[i][j - 1] + grid[i - 1][j - 1];
                else if(j == 1)
                    matrix[i][j] = matrix[i - 1][j] + grid[i - 1][j - 1];
                else
                    matrix[i][j] = grid[i - 1][j - 1] + Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }

        return matrix[x][y];
    }

    private void process(int[][] grid, int x, int y, int sum, int[][] cache) {
        if (x == width || y == height)
            return;

        sum += grid[y][x];

        if (cache[y][x] != -1 && cache[y][x] <= sum)
            return;

        cache[y][x] = sum;

        if (x == width - 1 && y == height - 1) {
            rsp = Math.min(rsp, sum);
        } else if (x == width - 1) {
            process(grid, x, y + 1, sum, cache);
        } else if (y == height -1) {
            process(grid, x + 1, y, sum, cache);
        } else {
            process(grid, x + 1, y, sum, cache);
            process(grid, x, y + 1, sum, cache);
        }
    }

    public static void main(String[] args) {

        int[][] nums = {{1,2,5}, {3,2,1}};
        Demo64 demo64 = new Demo64();
        System.out.println(demo64.minPathSum(nums));
    }
}
