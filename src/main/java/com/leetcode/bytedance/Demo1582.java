package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/9/4 12:47 上午
 * @Version 1.0
 */
public class Demo1582 {

    public int numSpecial(int[][] mat) {
        // 思路一：暴力
        int res = 0;
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    boolean valid = true;
                    for (int k = 0; k < m; k++) {
                        if (k != i && mat[k][j] == 1) {
                            valid = false;
                            break;
                        }
                    }
                    for (int k = 0; k < n && valid; k++) {
                        if (k != j && mat[i][k] == 1) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) res++;
                }
            }
        }
        return res;
    }
}
