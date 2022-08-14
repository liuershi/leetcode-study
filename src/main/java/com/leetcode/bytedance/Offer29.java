package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/8/14 7:01 下午
 * @Version 1.0
 */
public class Offer29 {




    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int m = matrix.length, n = matrix[0].length;
        int direction = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int total = m * n;
        int[] res = new int[total];

        Map<Integer, Set<Integer>> visitor = new HashMap<>();
        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            res[i] = matrix[row][col];
            visitor.putIfAbsent(row, new HashSet<>());
            visitor.get(row).add(col);

            int nextRow = directions[direction][0] + row;
            int nextCol = directions[direction][1] + col;
            if (nextRow == m || nextRow < 0 || nextCol == n || nextCol < 0 || (visitor.get(nextRow) != null && visitor.get(nextRow).contains(nextCol))) {
                direction = (direction + 1) % 4;
            }

            row += directions[direction][0];
            col += directions[direction][1];
        }
        return res;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
