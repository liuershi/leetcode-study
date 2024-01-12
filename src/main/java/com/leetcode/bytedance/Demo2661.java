package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2023/12/1 11:11 下午
 * @Version 1.0
 */
public class Demo2661 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int len = arr.length;

        Map<Integer, int[]> coordinates = new HashMap<>(len);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = mat[i][j];
                coordinates.put(val, new int[]{i, j});
            }
        }

        int[] rows = new int[row];
        int[] cols = new int[col];
        for (int i = 0; i < len; i++) {
            int[] coordinate = coordinates.get(arr[i]);
            if (++rows[coordinate[0]] == col || ++cols[coordinate[1]] == row) {
                return i;
            }
        }
        return -1;
    }
}
