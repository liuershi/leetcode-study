package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/11/17 9:51 下午
 * @Version 1.0
 */
public class Demo792 {

    public int numMatchingSubseq(String s, String[] words) {
//        return method1(s, words);
        // 思路二：二分查找
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        int rsp = words.length;;
        for (String word : words) {
            if (word.length() > s.length()) {
                rsp--;
                continue;
            }
            int prev = -1;
            for (int i = 0; i < word.length(); i++) {
                List<Integer> idxs = pos[word.charAt(i) - 'a'];
                // 当当前字符对于下标集合为空或者当前下标集合最大的下标小于等于上次遍历的下标
                if (idxs.isEmpty() || idxs.get(idxs.size() - 1) <= prev) {
                    rsp--;
                    break;
                }
                prev = binarySearch(idxs, prev);
            }
        }
        return rsp;
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

    public static void main(String[] args) {
        Demo792 demo792 = new Demo792();
        String[] strs = {"a", "bb", "acd", "ace"};
        System.out.println(demo792.numMatchingSubseq("abcde", strs));
    }

    /**
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param words
     * @return
     */
    private int method1(String s, String[] words) {
        int rsp = 0;
        for (String word : words) {
            if (word.length() <= s.length()) {
                int idx = -1;
                boolean check = true;
                for (int i = 0; i < word.length(); i++) {
                    if ((idx = s.indexOf(word.charAt(i), idx)) == -1) {
                        check = false;
                        break;
                    }
                    if (word.length() - i > word.length() - idx) {
                        check = false;
                        break;
                    }
                    idx++;
                }
                if (check) rsp++;
            }
        }
        return rsp;
    }
}
