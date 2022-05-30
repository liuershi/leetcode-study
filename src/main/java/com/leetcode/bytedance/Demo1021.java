package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/5/28 2:36 下午
 * @Version 1.0
 */
public class Demo1021 {

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') --idx;
            if (idx >= 1) sb.append(c);
            if (c == '(') ++idx;
        }
        return sb.toString();
    }
}
