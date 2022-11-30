package com.leetcode.bytedance;

import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/12/1 12:12 上午
 * @Version 1.0
 */
public class Demo1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1, manhattanDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (x == point[0] || y == point[1]) {
                int distance = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (distance < manhattanDistance) {
                    res = i;
                    manhattanDistance = distance;
                }
            }
        }
        return res;
    }
}
