package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/10/23 12:07 上午
 * @Version 1.0
 */
public class Demo1768 {

    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());
        for (int i = 0; i < len; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(len == word1.length() ? word2.substring(len) : word1.substring(len));
        return sb.toString();
    }
}
