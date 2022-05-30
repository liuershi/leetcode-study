package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/5/22 11:45 下午
 * @Version 1.0
 */
public class Demo66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return new int[]{1};

        int nextVal = 0;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + nextVal;
            int current = val % 10;
            nextVal = val / 10;
            digits[i] = current;
            if (nextVal == 0) {
                break;
            }
        }
        if (nextVal != 0) {
            int[] rsp = new int[digits.length + 1];
            System.arraycopy(digits, 0, rsp, 1, digits.length);
            rsp[0] = 1;
            return rsp;
        }
        return digits;
    }
}
