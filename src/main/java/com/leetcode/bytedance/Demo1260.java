package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author milindeyu
 * @Date 2022/7/20 12:48 上午
 * @Version 1.0
 */
public class Demo1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < k; i++) {
            int[] right = new int[m];
            for (int j = 0; j < m; j++) {
                right[j] = grid[(j + m - 1) % m][n - 1];
            }
            for (int j = 0; j < m; j++) {
                for (int l = n - 1; l > 0; l--) {
                    grid[j][l] = grid[j][l - 1];
                }
            }
            for (int j = 0; j < m; j++) {
                grid[j][0] = right[j];
            }
        }
        List<List<Integer>> rsp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                item.add(grid[i][j]);
            }
            rsp.add(item);
        }
        return rsp;
    }
}
