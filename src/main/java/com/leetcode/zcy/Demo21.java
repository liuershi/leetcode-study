package com.leetcode.zcy;

/**
 * @Author milindeyu
 * @Date 2022/4/27 10:37 下午
 * @Version 1.0
 */
public class Demo21 {

    /**
     * 实现不使用比较运算符比较两个32位整数的大小
     */


    /**
     * 方式一：存在溢出情况
     * @param a
     * @param b
     * @return
     */
    public static int getMax1(int a, int b) {
        int c = a - b;
        int sa = sign(c);
        int sb = flip(sa);
        return a * sa + b * sb;
    }

    /**
     * 方式二：解决了减法导致溢出的问题
     * @param a
     * @param b
     * @return
     */
    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb; // a和b同符号时则为0，否则为1
        int sameSab = flip(difSab); // a和b同符号时则为1，否则为0
        int returnA = sameSab * sc + difSab * sa;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    /**
     * x为负数则返回0， 否则返回1
     * @param x
     * @return
     */
    public static int sign(int x) {
        return (x >>> 31) ^ 1;
    }

    public static int flip(int x) {
        return x ^ 1;
    }

    public static void main(String[] args) {
        int a = -3;
        int b = Integer.MAX_VALUE;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
    }
}
