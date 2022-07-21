package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/7/17 6:50 下午
 * @Version 1.0
 */
public class Demo345 {

    class Node {
        int index;
        String val;

        public Node(int index, String val) {
            this.index = index;
            this.val = val;
        }
    }

    public String reverseVowels(String s) {
        if (s == null || "".equals(s.trim())) return s;
        Set<Character> vowels = new HashSet<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (vowels.contains(s.charAt(left)) || vowels.contains(s.charAt(right))) {
                while (!vowels.contains(s.charAt(right))) right--;
                while (!vowels.contains(s.charAt(left))) left++;
                if (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                }
            }
            left++;
            right--;
        }

        return new String(chars);
    }
}
