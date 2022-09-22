package com.leetcode.weekly.nio.twoweek72;

/**
 * @Author milindeyu
 * @Date 2022/8/27 10:50 下午
 * @Version 1.0
 */
public class Demo2177 {

    public long[] sumOfThree(long num) {
        if (num == 0) return new long[]{-1, 0 , 1};
        long val = num / 3;
        long remainder = num % 3;
        if (remainder == 0) return new long[]{val - 1, val, val + 1};
        else return new long[]{};
    }
}
