package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/20 10:59 下午
 * @Version 1.0
 */
public class Demo387 {

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) return i;
        }
        return -1;
        // 也可用hash表实现
    }
}
