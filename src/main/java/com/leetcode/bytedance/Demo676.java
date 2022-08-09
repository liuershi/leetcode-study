package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author milindeyu
 * @Date 2022/7/11 7:15 下午
 * @Version 1.0
 */
public class Demo676 {

    class MagicDictionary {

        Map<Integer, Set<String>> map;

        public MagicDictionary() {
            map = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String content : dictionary) {
                map.putIfAbsent(content.length(), new HashSet<>());
                map.get(content.length()).add(content);
            }
        }

        public boolean search(String searchWord) {
            if (!map.containsKey(searchWord.length())) return false;
            int len = searchWord.length();
            for (String content : map.get(len)) {
                int diff = 0;
                for (int l = 0, r = len - 1; l <= r; l++, r--) {
                    if (content.charAt(l) != searchWord.charAt(l)) diff++;
                    if (l != r && content.charAt(r) != searchWord.charAt(r)) diff++;
                    if (diff >= 2) break;
                }
                if (diff == 1) return true;
            }
            return false;
        }
    }
}
