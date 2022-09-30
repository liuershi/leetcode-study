package com.leetcode.mianshi;

/**
 * @Author milindeyu
 * @Date 2022/9/29 12:26 上午
 * @Version 1.0
 */
public class Demo0109 {

    public boolean isFlipedString(String s1, String s2) {
        // 思路：若s2由s1旋转而来，那么两个s2相加那么必定会包含s1
        if (s1.length() != s2.length()) return false;
        String ss = s2 + s2;
        return ss.contains(s1);
    }
}
