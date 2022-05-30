package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/8 11:40 下午
 * @Version 1.0
 */
public class Demo91 {

    public int numDecodings(String s) {
        int len = s == null ? 0 : s.length();
        if (len == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0')
                dp[i] += dp[i - 1];

            if (s.charAt(i - 1) != '0' && ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0')) <= 26) {
                int add = i > 1 ? dp[i - 2] : 1;
                dp[i] += add;
            }
        }

        return dp[len - 1];
    }


    public static void main(String[] args) {

        Demo91 demo91 = new Demo91();
        System.out.println(demo91.numDecodings("123123"));
    }
}
