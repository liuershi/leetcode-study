package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/8 12:45 上午
 * @Version 1.0
 */
public class Demo2185 {

    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            if (word.startsWith(pref))
                cnt++;
        }
        return cnt;
    }
}
