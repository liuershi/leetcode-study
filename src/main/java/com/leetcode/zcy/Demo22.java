package com.leetcode.zcy;

/**
 * @Author milindeyu
 * @Date 2022/4/27 10:52 下午
 * @Version 1.0
 */
public class Demo22 {

    /**
     * 判断指定的正数是否为2的幂
     * @param x
     * @return
     */
    public static boolean isTwoPower(int x) {
        if (x < 0) {
            throw new IllegalStateException();
        }
        return x != 0 && (x & (x - 1)) == 0;
    }

    /**
     * 判断指定的正数是否为4的幂
     * @param x
     * @return
     */
    public static boolean isFourPower(int x) {
        return isTwoPower(x) && ((x & 0x55555555) != 0);
    }

    public static void main(String[] args) {
        System.out.println(isTwoPower(0));
        System.out.println(isTwoPower(1));
        System.out.println(isTwoPower(2));
        System.out.println(isTwoPower(3));
        System.out.println(isTwoPower(4));

        System.out.println("============");

        System.out.println(isFourPower(0));
        System.out.println(isFourPower(2));
        System.out.println(isFourPower(3));
        System.out.println(isFourPower(8));
        System.out.println(isFourPower(16));
        System.out.println(isFourPower(32));
    }
}
