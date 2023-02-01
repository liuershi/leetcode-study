package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/2/1 6:42 下午
 * @Version 1.0
 */
public class Demo2325 {

    public String decodeMessage(String key, String message) {
        int[] memo = new int[26];
        int idx = 0;
        for (char c : key.toCharArray()) {
            if (c != ' ' && memo[c - 'a'] == 0) {
                memo[c - 'a'] = ++idx;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(" ");
            } else {
                sb.append((char) (memo[c - 'a'] + 97 - 1));
            }
        }
        return sb.toString();
    }
}
