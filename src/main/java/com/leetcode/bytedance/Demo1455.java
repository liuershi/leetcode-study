package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/8/21 3:13 下午
 * @Version 1.0
 */
public class Demo1455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.trim().split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
