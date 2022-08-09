package com.leetcode.bytedance;

/**
 * @Author milindeyu
 * @Date 2022/7/30 12:26 上午
 * @Version 1.0
 */
public class Demo557 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] contents = s.split(" ");
        for (int i = 0; i < contents.length; i++) {
            sb.append(reversal(contents[i]));
            if (i < contents.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public String reversal(String content) {
        if ("".equals(content.trim())) return "";
        int left = 0, right = content.length() - 1;
        char[] chars = content.toCharArray();
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right]= temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
