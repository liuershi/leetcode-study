package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2022/7/7 11:17 下午
 * @Version 1.0
 */
public class Demo648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] ss = sentence.split(" ");
        dictionary.sort(Comparator.comparingInt(String::length));
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            String container = container(dictionary, s);
            if (container == null) container = s;
            sb.append(container).append(" ");
        }
        return sb.toString().trim();
    }

    private String container(List<String> dictionary, String s) {
        for (String s1 : dictionary) {
            if (s.startsWith(s1)) return s1;
        }
        return null;
    }
}
