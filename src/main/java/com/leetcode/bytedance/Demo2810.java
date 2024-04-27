package com.leetcode.bytedance;

/**
 * @Author fishball
 * @Date 2024/4/1 9:23 下午
 * @Version 1.0
 */
public class Demo2810 {

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
