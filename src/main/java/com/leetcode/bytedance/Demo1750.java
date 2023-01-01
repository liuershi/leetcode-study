package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/28 4:32 下午
 * @Version 1.0
 */
public class Demo1750 {

    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            int removeChar = s.charAt(left);
            while (left < right && s.charAt(left + 1) == removeChar) {
                left++;
            }
            while (right > left && s.charAt(right - 1) == removeChar) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right))
                break;
            left++;
            right--;
        }

        return right - left + 1;
    }
}
