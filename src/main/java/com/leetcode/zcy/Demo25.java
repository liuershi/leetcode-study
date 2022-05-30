package com.leetcode.zcy;

import java.math.BigDecimal;

/**
 * @Author milindeyu
 * @Date 2022/4/30 11:42 下午
 * @Version 1.0
 */
public class Demo25 {

    /**
     * 问题：给定一个m x n 大小的区域，有一个人鲍勃，从指定位置(col, row)开始移动，
     * 每次能移动一步，限制其只能移动 k 步，若移动到区域外之后则认为其死亡，求其在移动
     * k步之后存活的概率
     * @param m 横向大小
     * @param n 纵向大小
     * @param row 起始位置的x坐标
     * @param col 起始位置的y坐标
     * @param k 指定步数
     * @return
     */
    public static double survivalProbability(int m, int n, int row, int col, int k) {
        int count = process(m, n, row, col, k);
        double total = Math.pow(4, k); // 鲍勃可能行走线路的总数量，即上下左右四个方向的k次方
        return new BigDecimal(count).divide(new BigDecimal(total)).doubleValue();
    }

    /**
     * 该函数返回其指定位置移动k步之后存活的行走线路数
     * @param m
     * @param n
     * @param row
     * @param col
     * @param k
     * @return
     */
    private static int process(int m, int n, int row, int col, int k) {
        // 越界时
        if (row > n || col > m || row < 0 || col < 0) {
            return 0;
        }
        // 无步数可走且此时还未越界说明存活了
        if (k == 0) {
            return 1;
        }
        --k;
        return process(m, n, row + 1, col, k)
                + process(m ,n , row - 1, col, k)
                + process(m, n, row, col + 1, k)
                + process(m, n, row, col - 1, k);
    }


    public static void main(String[] args) {
        System.out.println(survivalProbability(9, 10, 4, 5, 10));
    }
}
