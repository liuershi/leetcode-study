package com.leetcode.bytedance;

/**
 * 求1+2+…+n
 *
 * @Author milindeyu
 * @Date 2022/8/5 11:04 下午
 * @Version 1.0
 */
public class Offer64 {

    public int sumNums(int n) {
        // 注：求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
        // 所以，无法使用遍历的方式，由于上诉求解等同于等差数列求和
        // 等差数列求和的公式为：(a1 + an) * n / 2 , 即首项加尾项乘以n再除以2

        // 方式一：直接公式计算
//        return ((1 + n) * n) / 2;

        // 方式二：位运算
        return (int) (Math.pow(n , 2) + n) >> 1;
    }
}
