package com.leetcode.bytedance;


/**
 * @Author milindeyu
 * @Date 2022/9/7 11:02 下午
 * @Version 1.0
 */
public class Demo1592 {
    public String reorderSpaces(String text) {
        // 思路：直接模拟
        int len = text.length();
        String[] words = text.trim().split("\\s+");
        int spaceCount = len;
        for (String word : words) {
            spaceCount -= word.length();
        }

        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < spaceCount; i++) {
                sb.append(" ");
            }
        } else {
            int spaceSize = spaceCount / (words.length - 1);
            int spaceSurplus = spaceCount % (words.length - 1);

            StringBuilder appendContent = new StringBuilder();
            for (int i = 0; i < spaceSize; i++) appendContent.append(" ");

            for (int i = 0; i < words.length; i++) {
                if (i > 0) sb.append(appendContent);
                sb.append(words[i]);
            }
            for (int i = 0; i < spaceSurplus; i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
