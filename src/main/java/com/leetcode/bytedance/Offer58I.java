package com.leetcode.bytedance;

/**
 * @author zhangwei151
 * @date 2022/9/24 23:14
 */
public class Offer58I {

    public String reverseWords(String s) {
        if ("".equals(s.trim())) return "";
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i].trim())) {
                sb.append(strs[i].trim()).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
