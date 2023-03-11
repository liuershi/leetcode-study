package com.leetcode.weekly.WEEK334;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2023/2/26 10:42 上午
 * @Version 1.0
 */
public class Demo6368 {

    public static int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long remaining = 0;
        int[] res = new int[n];
        if ((remaining = (word.charAt(0) - '0') % m) == 0) {
            res[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (res[i - 1] == 1 && (remaining = (word.charAt(i) - '0') % m) == 0) {
                res[i] = 1;
            } else if (res[i - 1] == 0 && ((remaining = ((remaining * 10 + (word.charAt(i) - '0')) % m)) == 0)) {
                res[i] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divisibilityArray("998244353", 3)));
    }
}
