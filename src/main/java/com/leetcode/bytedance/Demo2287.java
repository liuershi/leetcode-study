package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2023/1/13 10:04 下午
 * @Version 1.0
 */
public class Demo2287 {

    public int rearrangeCharacters(String s, String target) {
        int n = 26;
        int[] smemo = new int[n];
        int[] dmemo = new int[n];

        for (char c : s.toCharArray()) {
            smemo[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            dmemo[c - 'a']++;
        }

        int cnt = 0;
        out:while (true) {
            for (int i = 0; i < n; i++) {
                if ((smemo[i] -= dmemo[i]) < 0) {
                    break out;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
