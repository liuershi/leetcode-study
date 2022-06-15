package com.leetcode.bytedance;

import java.util.*;

/**
 * @Author milindeyu
 * @Date 2022/6/13 10:09 下午
 * @Version 1.0
 */
public class Demo211 {

    static class WordDictionary {

        static class Trip {
            boolean isEnd; // 是否叶子节点
            Trip[] next; // 后继节点集合

            public Trip() {
                this.isEnd = false;
                this.next = new Trip[26];
            }

            public void insert(String word) {
                int len = word.length();
                Trip node = this;
                for (int i = 0; i < len; i++) {
                    int index = word.charAt(i) - 'a'; // 将字符转换为其对应的数组下标位置
                    if (node.next[index] == null) {
                        node.next[index] = new Trip();
                    }
                    node = node.next[index];
                }
                node.isEnd = true;
            }
        }

        Trip root;

        public WordDictionary() {
            root = new Trip();
        }

        public void addWord(String word) {
            root.insert(word);
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int index, Trip node) {
            if (word.length() == index) return node.isEnd;
            // 判断当前字符是否为字母
            char c = word.charAt(index);
            if (Character.isLetter(c)) {
                int idx = c - 'a';
                if (node.next[idx] != null && dfs(word, index + 1, node.next[idx]))
                    return true;
            } else {
                // 此时当前字符为'.'，即通配
                for (int i = 0; i < 26; i++) {
                    Trip trip = node.next[i];
                    if (trip != null && dfs(word, index + 1, trip))
                        return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
    }
}
