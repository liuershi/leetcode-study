package com.leetcode.bytedance;

import java.util.Arrays;

/**
 * @Author fishball
 * @Date 2024/3/13 12:49 上午
 * @Version 1.0
 */
public class Demo2864 {

    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                chars[idx++] = '1';
            }
        }

        if (idx < chars.length) {
            Arrays.fill(chars, idx - 1, chars.length, '0');
        }

        chars[chars.length - 1] = '1';

        return new String(chars);
    }
}
