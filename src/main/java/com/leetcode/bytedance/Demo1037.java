package com.leetcode.bytedance;

import java.math.BigDecimal;

/**
 * @Author milindeyu
 * @Date 2022/6/8 9:39 下午
 * @Version 1.0
 */
public class Demo1037 {

    public boolean isBoomerang(int[][] points) {
        // 计算点0到点1和点2的向量
        // 三点不在一条直线等价于 == 这两个向量的叉乘结果不为零
        int[] v1 = {points[0][0] - points[1][0], points[0][1] - points[1][1]};
        int[] v2 = {points[0][0] - points[2][0], points[0][1] - points[2][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }
}
