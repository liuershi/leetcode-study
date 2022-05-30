package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/8 4:48 下午
 * @Version 1.0
 */
public class Demo85 {

    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0)
            return 0;

        // 方法一：将每个点左边1的个数存起来
        int width = matrix[0].length;
        int[][] leftOneCache = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '1')
                    leftOneCache[i][j] = j == 0 ? 0 : leftOneCache[i][j - 1] + 1;
            }
        }

        int rsp = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int wd = leftOneCache[i][j];
                int area = wd;
                if (wd != 0) {
                    for (int k = i; k >= 0; k--) {
                        wd = Math.min(wd, leftOneCache[k][j]);
                        area = Math.max(area, wd * (i - k + 1));
                    }
                }
                rsp = Math.max(area, rsp);
            }
        }

        return rsp;
    }

    public static void main(String[] args) {
        Demo85 demo85 = new Demo85();
        char[][] chars = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(demo85.maximalRectangle(chars));
    }
}
