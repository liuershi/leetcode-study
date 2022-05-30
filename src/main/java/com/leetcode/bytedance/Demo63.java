package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/5 10:22 下午
 * @Version 1.0
 */
public class Demo63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -2;
                else
                    obstacleGrid[i][j] = -1;
            }
        }

        return process(obstacleGrid, 0, 0);
    }

    private int process(int[][] obstacleGrid, int x, int y) {
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length)
            return 0;

        if (obstacleGrid[x][y] != -1)
            return obstacleGrid[x][y] == -2 ? 0 : obstacleGrid[x][y];


        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1)
            return 1;

        if (x == obstacleGrid.length - 1) {
            obstacleGrid[x][y] = process(obstacleGrid, x, y + 1);
            return obstacleGrid[x][y];
        }

        if (y == obstacleGrid[0].length - 1) {
            obstacleGrid[x][y] = process(obstacleGrid, x + 1, y);
            return obstacleGrid[x][y];
        }
        obstacleGrid[x][y] = process(obstacleGrid, x + 1, y) + process(obstacleGrid, x, y + 1);
        return obstacleGrid[x][y];
    }
}
