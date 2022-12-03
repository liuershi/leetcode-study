package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/3 6:14 下午
 * @Version 1.0
 */
public class Demo1796 {

    public int secondHighest(String s) {
        int first = -1, sec = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int val = c - '0';
                if (val > first) {
                    sec = first;
                    first = val;
                } else if (val < first && val > sec) {
                    sec = val;
                }
            }
        }
        return sec;
    }
}
