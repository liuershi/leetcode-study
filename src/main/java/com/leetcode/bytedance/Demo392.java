package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/23 2:51 下午
 * @Version 1.0
 */
public class Demo392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((start = t.indexOf(s.charAt(i), start)) == -1) return false;
        }
        return true;
    }
}
