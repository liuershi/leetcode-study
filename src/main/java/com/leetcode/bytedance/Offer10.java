package com.leetcode.bytedance;

/**
 * 斐波那契数列
 *
 * @Author milindeyu
 * @Date 2022/8/5 12:50 上午
 * @Version 1.0
 */
public class Offer10 {

    public int fib(int n) {
        if (n < 2) return n;
        // 说明：该例子中，由于n的范围在1～100，较大，不能使用递归的方式计算，否则会出现溢出的情况
        // 直接循环计算即可
        double divisor = 1e9 + 7;
        int prev = 0, cur = 1;
        for (int i = 1; i <= n; i++) {
            int temp = cur;
            cur += prev;
            prev = temp;
            cur %= divisor;
        }
        return cur;
    }
}
