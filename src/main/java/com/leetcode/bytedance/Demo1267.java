package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/8/24 9:01 下午
 * @Version 1.0
 */
public class Demo1267 {
    public int countServers(int[][] grid) {
        // 思路：通过 rows[] 和 cols[] 数组存放在对于行和列存在的情况，
        // 若大于1则说明此时有多个服务器在同一条线上，那么后续再次遍历整个
        // 矩阵，符合条件（是指该点值为1且rows[x]或cols[x]值大于1）则加1即可

        int row = grid.length, col = grid[0].length;
        int[] rows = new int[row], cols = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > 0 && (rows[i] > 1 || cols[j] > 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
