package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/6/29 10:39 下午
 * @Version 1.0
 */
public class Demo326 {

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
