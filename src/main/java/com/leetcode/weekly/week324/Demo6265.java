package com.leetcode.weekly.week324;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/12/18 10:31 上午
 * @Version 1.0
 */
public class Demo6265 {

    public int similarPairs(String[] words) {
        int res = 0;
        int n = words.length;
        Set<Character> set = new HashSet<>(100);
        for (int i = 0; i < n - 1; i++) {
            for (char c : words[i].toCharArray()) {
               set.add(c);
            }
            for (int j = i + 1; j < n; j++) {
                boolean search = true;
                Set<Character> subSet = new HashSet<>();
                for (char c : words[j].toCharArray()) {
                    if (!set.contains(c)) {
                        search = false;
                        break;
                    }
                    subSet.add(c);
                }
                if (search && set.size() == subSet.size()) res++;
            }
        }
        return res;
    }
}
