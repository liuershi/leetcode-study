package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2023/5/6 10:03 下午
 * @Version 1.0
 */
public class Demo1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) {
            return -1;
        }
        char[] previous = new char['s'];
        String s = "croakc";
        for (int i = 1; i < s.length(); i++) {
            previous[s.charAt(i)] = s.charAt(i - 1);
        }

        int[] ans = new int['s'];
        for (char c : croakOfFrogs.toCharArray()) {
            char prev = previous[c];
            if (ans[prev] > 0) {
                ans[prev]--;
            } else if (c != 'c') {
                return -1;
            }
            ans[c]++;
            if (ans['c'] > 0 || ans['r'] > 0 || ans['o'] > 0 || ans['a'] > 0) {
                return -1;
            }
        }

        return ans['k'];
    }
}
