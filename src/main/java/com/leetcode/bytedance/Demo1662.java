package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/11/1 11:01 下午
 * @Version 1.0
 */
public class Demo1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int charIdx1 = 0, charIdx2 = 0;
        int wordIdx1 = 0, wordIdx2 = 0;
        while (wordIdx1 < word1.length && wordIdx2 < word2.length) {
            if (word1[wordIdx1].charAt(charIdx1) != word2[wordIdx2].charAt(charIdx2))
                return false;

            if (charIdx1 == word1[wordIdx1].length() - 1) {
                wordIdx1++;
                charIdx1 = 0;
            } else charIdx1++;
            if (charIdx2 == word2[wordIdx2].length() - 1) {
                wordIdx2++;
                charIdx2 = 0;
            } else charIdx2++;
        }
        return wordIdx1 == word1.length && wordIdx2 == word2.length;
    }
}
