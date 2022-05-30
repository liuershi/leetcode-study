package com.leetcode.zcy;

/**
 *
 * 实现两个数的加减乘除，不能使用加减乘除符号
 *
 * 注意：出现溢出不需要管
 *
 * @Author milindeyu
 * @Date 2022/4/27 11:33 下午
 * @Version 1.0
 */
public class Demo23 {

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public static int addition(int a, int b) {
        while (b != 0) {
            int x = a;
            a = a ^ b; // 等效于无进位的相加
            b = (x & b) << 1; // 进位相加
        }
        return a;
    }

    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a, int b) {
        // a - b = a + (-b)
        // 一个数的负数等于其取反加一
        // 所以：-b = ~b + 1
        return addition(a, addition(~b, 1));
    }

    /**
     * 乘法
     * @param a
     * @param b
     * @return
     */
    public static int multi(int a, int b) {
        int rsp = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                rsp = addition(rsp, a);
            }
            a = a << 1;
            b = b >>> 1;
        }
        return rsp;
    }

    public static void main(String[] args) {
        System.out.println(addition(34, 3));
        System.out.println(minus(12, -3));
        System.out.println(multi(-3, -5));
    }
}
