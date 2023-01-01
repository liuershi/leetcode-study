package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/1 4:58 下午
 * @Version 1.0
 */
public class Demo2351 {

    public char repeatedCharacter(String s) {
        int[] memo = new int[26];
        for (char c : s.toCharArray()) {
            if (++memo[c - 'a'] == 2) {
                return c;
            }
        }
        return 'a';
    }
}
