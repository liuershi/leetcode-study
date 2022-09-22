package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/14 11:01 下午
 * @Version 1.0
 */
public class Demo1137 {

    public int tribonacci(int n) {
        if (n < 4) {
            return n <= 1 ? n : n - 1;
        }
        int[] memo = new int[n + 1];
        return help(memo, n);
    }

    public int help(int[] memo, int n) {
        if (n < 2) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = help(memo, n - 3) + help(memo, n - 2) + help(memo, n - 1);
        return memo[n];
    }

    public static void main(String[] args) {

    }
}
