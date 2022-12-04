package com.leetcode.weekly.week322;

/**
 * @Author milindeyu
 * @Date 2022/12/4 10:31 上午
 * @Version 1.0
 */
public class Demo6253 {

    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                return words[i].charAt(words[i].length() - 1) == words[0].charAt(0);
            } else if (i < words.length - 1) {
                if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0))
                    return false;
            }
        }
        return true;
    }
}
