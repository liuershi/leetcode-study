package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/3/19 11:29 下午
 * @Version 1.0
 */
public class Demo54 {

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Demo54 demo54 = new Demo54();
        System.out.println(demo54.spiralOrder(ints));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        List<Integer> result = new ArrayList<>(total);

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;

        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            result.add(matrix[row][col]);
            matrix[row][col] = -101;

            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];
            // 判断边界
           if (nextCol >= cols || nextCol < 0 || nextRow >= rows || matrix[nextRow][nextCol] == -101) {
               direction = (direction + 1) % 4;
           }

            row += directions[direction][0];
            col += directions[direction][1];
        }

        return result;
    }
}
