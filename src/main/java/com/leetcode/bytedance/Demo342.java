package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/29 10:18 下午
 * @Version 1.0
 */
public class Demo342 {

    public boolean isPowerOfFour(int n) {
        return isPowerOfTwo(n) && (n & 0x55555555) != 0;
    }

    private boolean isPowerOfTwo(int n) {
        return (n -1 & n) == 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(27));
        System.out.println(Integer.toBinaryString(81));
    }
}
