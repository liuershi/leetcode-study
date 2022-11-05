package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/3 12:12 上午
 * @Version 1.0
 */
public class Demo1668 {

    public int maxRepeating(String sequence, String word) {
        // 思路：直接遍历
        if (sequence.length() < word.length()) return 0;
        StringBuilder sb = new StringBuilder(word);
        int rsp = 0;
        while (sequence.contains(sb.toString())) {
            rsp++;
            sb.append(word);
        }
        return rsp;
    }
}
