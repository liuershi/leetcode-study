package com.leetcode.demo;

/**
 * @Author milindeyu
 * @Date 2022/7/7 11:41 下午
 * @Version 1.0
 */
public class Demo509 {

    public int fib(int n) {
        int[] cache = new int[n + 1];
        return recursion(n, cache);
    }

    private int recursion(int n, int[] cache) {
        if (n < 2) return n;
        if (cache[n] != 0) return cache[n];
        cache[n] = recursion(n - 1, cache) + recursion(n - 2, cache);
        return cache[n];
    }


    public int fibTwo(int n) {
        if (n < 2) return n;
        int front = 0, post = 1;
        for (int i = 2; i < n; i++) {
            int temp = post;
            post += front;
            front = temp;
        }
        return post;
    }
}
