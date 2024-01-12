package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2024/1/11 11:42 下午
 * @Version 1.0
 */
public class Demo2645 {

    public int addMinimum(String word) {
        char[] chars = word.toCharArray();
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] >= chars[i]) {
                count++;
            }
        }
        return count * 3 - chars.length;
    }
}
