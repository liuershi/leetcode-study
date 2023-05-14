package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author milindeyu
 * @Date 2023/3/30 12:19 上午
 * @Version 1.0
 */
public class Demo1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}
