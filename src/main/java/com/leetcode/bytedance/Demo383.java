package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2022/7/19 11:24 下午
 * @Version 1.0
 */
public class Demo383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length(), len2 = magazine.length();
        if (len1 > len2) return false;

        int[] alphabet = new int[26];
        for (int i = 0; i < len2; i++) {
            alphabet[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len1; i++) {
            if (--alphabet[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
