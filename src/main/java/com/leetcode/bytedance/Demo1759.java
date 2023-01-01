package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/27 6:24 下午
 * @Version 1.0
 */
public class Demo1759 {

    public int countHomogenous(String s) {
        long res = 0;
        int MOD = (int) (1e9 + 7);
        int len = s.length(), prev = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1 || s.charAt(i + 1) != s.charAt(i)) {
                int n = i - prev + 1;
                res = (res + ((long) n * (n + 1)) / 2) % MOD;
                prev = i + 1;
            }
        }
        return (int) res;
    }
}
