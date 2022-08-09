package com.leetcode.bytedance;

/**
 * 阶乘的后缀零
 *
 * @Author milindeyu
 * @Date 2022/7/28 9:50 下午
 * @Version 1.0
 */
public class Demo172 {

    public int trailingZeroes(int n) {
        int rsp = 0;
        // 算一下乘法因子里有多少个5
        while (n >= 5) {
           rsp += n / 5;
           n /= 5;
        }
        return rsp;

    }
}
