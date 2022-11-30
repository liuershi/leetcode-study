package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/11/25 10:09 下午
 * @Version 1.0
 */
public class Demo809 {

    public int expressiveWords(String s, String[] words) {
        int res = 0;

        for (String word : words) {
            if (isStretchy(word, s))
                res++;
        }

        return res;
    }

    private boolean isStretchy(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) != s.charAt(j)) {
                return false;
            }
            char wc = word.charAt(i);
            int icnt = 0;
            while (i < word.length() && word.charAt(i) == wc) {
                i++;
                icnt++;
            }

            int jcnt = 0;
            while (j < s.length() && s.charAt(j) == wc) {
                j++;
                jcnt++;
            }

            if (jcnt < icnt) return false;
            if (jcnt != icnt && jcnt < 3) return false;
        }
        System.out.println(i + ":" + j);
        return i == word.length() && j == s.length();
    }

    public static void main(String[] args) {
        Demo809 demo809 = new Demo809();
        String str = "heeellooo";
        String[] strings = {"hello", "hi", "helo"};
        System.out.println(demo809.expressiveWords(str, strings));
    }
}
