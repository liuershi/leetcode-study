package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/14 6:51 下午
 * @Version 1.0
 */
public class Demo498 {

    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int count = row * col;
        int[] rsp = new int[count];
        int r = 0, c = 0;
        for (int i = 0; i < count; i++) {
            // 通过横坐标、纵坐标的和取奇偶判断方向
            if ((r + c) % 2 == 0) {
                // 偶数时方向向右上角
                if (c == col - 1) // 若当前点在右顶角时，向下移动
                    r++;
                else if (r == 0) // 当前点在上边时，向右移动
                    c++;
                else {
                    // 否则，向右上方移动
                    c++;
                    r--;
                }
            } else {
                // 奇数时方向向左下角
                if (r == row - 1)
                    c++;
                else if (c == 0)
                    r++;
                else {
                    r++;
                    c--;
                }
            }
            System.out.println(r + ":" + c);
            rsp[i] = mat[r][c];
        }
        return rsp;
    }
}
