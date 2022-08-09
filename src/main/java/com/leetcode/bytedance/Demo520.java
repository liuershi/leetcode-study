package com.leetcode.bytedance;

/**
 * 检测大写字母
 *
 * @Author milindeyu
 * @Date 2022/7/30 12:15 上午
 * @Version 1.0
 */
public class Demo520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        if (Character.isUpperCase(word.charAt(0))) {
            if (Character.isUpperCase(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) return false;
                }
            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) return false;
                }
            }
        } else {
            int left = 1, right = word.length() - 1;
            while (left <= right) {
                if (Character.isUpperCase(word.charAt(left)) || Character.isUpperCase(word.charAt(right))) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
