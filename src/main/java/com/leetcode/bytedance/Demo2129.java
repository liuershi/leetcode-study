package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2024/3/11 12:11 上午
 * @Version 1.0
 */
public class Demo2129 {


    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        char[] chars = title.toCharArray();
        int len = chars.length;
        int left = 0, right = 0;
        while (right < len) {
            while (right < len && title.charAt(right) != ' ') {
                right++;
            }
            if (right == len) {
                if (right - left > 2) {
                    processFirstUppercase(left, right, chars, sb);
                } else {
                    processLowercase(left, right, chars, sb);
                }
                sb.deleteCharAt(len);
                break;
            }

            if (right - left > 2) {
                processFirstUppercase(left, right, chars, sb);
            } else {
                processLowercase(left, right, chars, sb);
            }
            left = ++right;
        }

        return sb.toString();
    }

    private void processFirstUppercase(int left, int right, char[] chars, StringBuilder sb) {
        sb.append(Character.toUpperCase(chars[left++]));
        for (int i = left; i < right; i++) {
            sb.append(Character.toLowerCase(chars[i]));
        }
        sb.append(" ");
    }

    private void processLowercase(int left, int right, char[] chars, StringBuilder sb) {
        for (int i = left; i < right; i++) {
            sb.append(Character.toLowerCase(chars[i]));
        }
        sb.append(" ");
    }
}
