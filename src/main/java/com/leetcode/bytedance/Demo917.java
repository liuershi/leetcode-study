package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/12/11 9:45 下午
 * @Version 1.0
 */
public class Demo917 {

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                swap(left, right, chars);
            } else if (Character.isLetter(chars[left])) {
                while (left < right && !Character.isLetter(chars[right])) {
                    right--;
                }
                if (right > left) {
                    swap(left, right, chars);
                }
            } else if (Character.isLetter(chars[right])){
                while (left < right && !Character.isLetter(chars[left])) {
                    left++;
                }
                if (right > left) {
                    swap(left, right, chars);
                }
            }

            left++;
            right--;
        }
        return new String(chars);
    }

    public void swap(int left, int right, char[] chars) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
