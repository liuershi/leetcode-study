package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/10 7:31 下午
 * @Version 1.0
 */
public class Offer46 {

    public int translateNum(int num) {
        if (num < 10) return 1;
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int total = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            dp[i] = dp[i - 1];
            if (total > 9 && total < 26) {
                if (i < 2) dp[i]++;
                else dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}
