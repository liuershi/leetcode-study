package com.leetcode.weekly.week327;

/**
 * @Author milindeyu
 * @Date 2023/1/8 10:42 上午
 * @Version 1.0
 */
public class Demo6284 {

    public boolean isItPossible(String word1, String word2) {
        if (word1.length() == 1 && word2.length() == 1) return true;
        int[] memo1 = new int[26], memo2 = new int[26];
        for (char c : word1.toCharArray()) {
            memo1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            memo2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (memo1[i] == 0) continue;
            for (int j = 0; j < 26; j++) {
                if (memo2[j] == 0) continue;
                swap(memo1, i, memo2, j);
                if (valid(memo1, memo2))
                    return true;
                swap(memo1, j, memo2, i);
            }
        }

        return false;
    }

    private boolean valid(int[] memo1, int[] memo2) {
        int diff1 = 0, diff2 = 0;
        for (int i : memo1) {
            if (i != 0) diff1++;
        }
        for (int i : memo2) {
            if (i != 0) diff2++;
        }
        return diff1 == diff2;
    }

    private void swap(int[] memo1, int i, int[] memo2, int j) {
        memo1[i]--;
        memo1[j]++;
        memo2[j]--;
        memo2[i]++;
    }

    public static void main(String[] args) {
        Demo6284 demo6284 = new Demo6284();
        System.out.println(demo6284.isItPossible("a", "bb"));
    }
}
