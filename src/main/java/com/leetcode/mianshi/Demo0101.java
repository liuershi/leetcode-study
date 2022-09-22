package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/8/14 5:58 下午
 * @Version 1.0
 */
public class Demo0101 {

    public boolean isUnique(String astr) {
        byte[] memo = new byte[26];
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            memo[index] ^= 1;
            if (memo[index] == 0) return false;
        }
        return true;
    }
}
