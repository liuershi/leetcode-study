package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/7/14 9:08 下午
 * @Version 1.0
 */
public class Demo745 {

    class WordFilter {

        /**
         * 存储每个字符串可能的前后缀组成的字符串和其对应的下标
         */
        Map<String, Integer> dictionary;

        public WordFilter(String[] words) {
            int len = words.length;
            dictionary = new HashMap<>(len);
            for (int i = 0; i < len; i++) {
                String word = words[i];
                for (int j = 1; j <= word.length(); j++) {
                    for (int k = 1; k <= word.length(); k++) {
                        dictionary.put(word.substring(0, j) + "-" + word.substring(word.length() - k), i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return dictionary.getOrDefault(pref + "-" + suff, -1);
        }
    }
}
