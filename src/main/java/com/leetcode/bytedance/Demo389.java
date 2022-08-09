package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author milindeyu
 * @Date 2022/7/21 11:24 下午
 * @Version 1.0
 */
public class Demo389 {

    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']++;
            if (i < s.length()) chars[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) return (char) (i + 'a');
        }
        return 'a';
    }


}
