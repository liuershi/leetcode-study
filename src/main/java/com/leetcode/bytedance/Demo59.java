package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/23 9:59 下午
 * @Version 1.0
 */
public class Demo59 {

    public int[][] generateMatrix(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        if (n == 1)
            return new int[][]{{1}};
        int[][] rsp = new int[n][n];

        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int nextDirection = 0;
        int row = 0, line = 0;
        for (int i = 1; i <= n * n; i++) {
            rsp[row][line] = i;

            int nextRow = row + direction[nextDirection][0];
            int nextLine = line + direction[nextDirection][1];
            if (nextRow >= n || nextLine >= n || nextLine < 0 || rsp[nextRow][nextLine] != 0) {
                nextDirection = (nextDirection + 1) % 4;
            }

            row += direction[nextDirection][0];
            line += direction[nextDirection][1];
        }
        return rsp;
    }
}
