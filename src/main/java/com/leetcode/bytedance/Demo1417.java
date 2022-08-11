package com.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/reformat-the-string/
 *
 * @author zhangwei151
 * @date 2022/8/11 9:55
 */
public class Demo1417 {

    public String reformat(String s) {
        List<Character> digit = new ArrayList<>();
        List<Character> letter = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) letter.add(s.charAt(i));
            else digit.add(s.charAt(i));
        }
        int abs = Math.abs(digit.size() - letter.size());
        if (abs >= 2) return "";
        else {
            char[] content = new char[s.length()];
            if (digit.size() >= letter.size()) {
                for (int i = 0; i < digit.size(); i++) {
                    content[i * 2] = digit.get(i);
                    if (i < letter.size()) content[i * 2 - 1] = letter.get(i);
                }
            } else {
                for (int i = 0; i < letter.size(); i++) {
                    content[i * 2] = letter.get(i);
                    if (i < digit.size()) content[i * 2 - 1] = digit.get(i);
                }
            }
            return new String(content);
        }
    }
}
