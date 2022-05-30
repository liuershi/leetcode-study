package com.leetcode.zcy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/4/18 11:43 下午
 * @Version 1.0
 */
public class Demo11 {

    /**
     * 求出指定字符串的所有子序列
     *      例：字符串abc ==>
     *          子序列：abc、ab、ac、bc、a、b、c、null
     * @param s
     * @return
     */
    public List<String> allSubsequence(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        char[] chars = s.toCharArray();
        process(chars, result, 1, "");
        return result;
    }

    private void process(char[] chars, List<String> result, int index, String content) {
        if (index == chars.length) {
            result.add(content);
            result.add(content + chars[index - 1]);
            return;
        }
        String append = content + chars[index - 1];
        ++index;

        process(chars, result, index, append);
        process(chars, result, index, content);
    }

    public static void main(String[] args) {
        Demo11 demo11 = new Demo11();
        System.out.println(demo11.allSubsequence("abcd"));
    }
}
