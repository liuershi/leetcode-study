package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/4/11 9:24 下午
 * @Version 1.0
 */
public class Demo357 {
    public int countNumbersWithUniqueDigits(int n) {
        int rsp = 1;
        int product = 9;
        for (int i = 1; i <= n; i++) {
            rsp += product;
            product *= (10 - i);
        }
        return rsp;
    }

    public static void main(String[] args) {
        Demo357 demo357 = new Demo357();
        System.out.println(demo357.countNumbersWithUniqueDigits(3));
    }
}
