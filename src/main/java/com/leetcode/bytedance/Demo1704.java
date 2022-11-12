package com.leetcode.bytedance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/11/11 12:14 上午
 * @Version 1.0
 */
public class Demo1704 {

    public boolean halvesAreAlike(String s) {
        int count = 0;
        int halfLen = s.length() >> 1;

        String str = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {
            if (str.indexOf(s.charAt(i)) >= 0) {
                if (i < halfLen)
                    count++;
                else
                    count--;
            }
        }
        return count == 0;
    }
}
