package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/8 12:02 上午
 * @Version 1.0
 */
public class Demo1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        // 思路：int数组存储allowed字符串
        int[] memo = new int[26];
        for (char c : allowed.toCharArray()) {
            memo[c - 'a']++;
        }
        int rsp = 0;
        for (String word : words) {
            boolean success = true;
            for (char c : word.toCharArray()) {
                if (memo[c - 'a'] == 0) {
                    success = false;
                    break;
                }
            }
            if (success) rsp++;
        }
        return rsp;
    }
}
