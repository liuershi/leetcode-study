package com.leetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/12/6 12:51 上午
 * @Version 1.0
 */
public class Demo1805 {

    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> nums = new HashSet<>();
        int index = 0;
        while (index < chars.length) {
            if (Character.isDigit(chars[index])) {
                // 此时字符为数字，需去掉前缀为0的情况
                while (index < chars.length && chars[index] == '0') {
                    index++;
                }
                if (index == chars.length || !Character.isDigit(chars[index])) {
                    // 说明此时从start开始到结束都为0、或者只有一个字符为0的情况
                    nums.add("0");
                } else {
                    // 说明此时开始字符不为0
                    int start = index;
                    while (index < chars.length && Character.isDigit(chars[index])) {
                        index++;
                    }
                    nums.add(word.substring(start, index));
                }
            }
            index++;
        }
        return nums.size();
    }
}
