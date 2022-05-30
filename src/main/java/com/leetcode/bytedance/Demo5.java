package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/3/20 2:47 下午
 * @Version 1.0
 */
public class Demo5 {
    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 方式一：暴力算法
//        return method1(s);

        // 方式二：动态规划
        int begin = 0;
        int max = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = j - i < 3 || dp[i + 1][j - 1];
                if (dp[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    private String method1(String s) {
        String result = "";
        int length = s.length();
        int max = 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + max; j <= length; j++) {
                String content = s.substring(i, j);
                if (isPalindrome(content) && content.length() > result.length()) {
                    result = content;
                    max = content.length();
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        System.out.println(demo5.longestPalindrome("aaaa"));
    }
}
