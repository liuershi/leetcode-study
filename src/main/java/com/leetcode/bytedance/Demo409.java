package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/7/24 9:22 下午
 * @Version 1.0
 */
public class Demo409 {

    public int longestPalindrome(String s) {
//        return method01(s);

        // 基于数组实现
        int[] upper = new int[26];
        int[] lower = new int[26];
        int rsp = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                if (lower[c - 'a'] != 0) {
                    rsp += 2;
                    lower[c - 'a']--;
                } else lower[c - 'a']++;
            } else {
                if (upper[c - 'A'] != 0) {
                    rsp += 2;
                    upper[c - 'A']--;
                } else upper[c - 'A']++;
            }
        }

        boolean single = false;
        for (int i = 0; i < 26; i++)
            if (lower[i] != 0 || upper[i] != 0) {
                single = true;
                break;
            }
        return single ? rsp + 1 : rsp;
    }

    /**
     * 哈希表实现
     * @param s
     * @return
     */
    private int method01(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>(len);
        int rsp = 0;
        for (int i = 0; i < len; i++) {
            if (set.contains(s.charAt(i))) {
                rsp += 2;
                set.remove(s.charAt(i));
                continue;
            }
            set.add(s.charAt(i));
        }
        return set.isEmpty() ? rsp : rsp + 1;
    }
}
