package com.leetcode.bytedance;

import java.util.*;

/**
 * 每日一题：数组中的字符串匹配
 *
 * @Author milindeyu
 * @Date 2022/8/6 12:03 上午
 * @Version 1.0
 */
public class Demo1408 {

    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> rsp = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = words.length - 1; j > i && words[j].length() > words[i].length(); j--) {
                if (words[j].contains(words[i])) rsp.add(words[i]);
            }
        }
        return rsp;
    }
}
