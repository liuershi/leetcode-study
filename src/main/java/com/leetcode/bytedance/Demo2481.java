package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/6/17 6:55 下午
 * @Version 1.0
 */
public class Demo2481 {

    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        return (n & 1) == 1 ? n : n - 1;
    }
}
