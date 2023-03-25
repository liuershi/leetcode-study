package com.leetcode.weekly.week336;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2023/3/12 10:33 上午
 * @Version 1.0
 */
public class Demo6315 {

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        Set<Character> set = new HashSet<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                count++;
            }
        }
        return count;
    }
}
